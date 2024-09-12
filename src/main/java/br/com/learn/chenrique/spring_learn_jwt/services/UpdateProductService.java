package br.com.learn.chenrique.spring_learn_jwt.services;

import java.util.Optional;

import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.learn.chenrique.spring_learn_jwt.exceptions.ProductNotFoundException;
import br.com.learn.chenrique.spring_learn_jwt.model.Product;
import br.com.learn.chenrique.spring_learn_jwt.model.dto.ProductDTO;
import br.com.learn.chenrique.spring_learn_jwt.repository.ProductRepository;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {

    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @CachePut(value = "productCache", key = "#input.getId()")
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand input) {
        Optional<Product> result = productRepository.findById(input.getId());

        if (result.isPresent()) {
            Product product = input.getProduct();
            product.setId(input.getId());
            productRepository.save(product);
            return ResponseEntity.ok(new ProductDTO(product));
        }

        throw new ProductNotFoundException();
    }
}
