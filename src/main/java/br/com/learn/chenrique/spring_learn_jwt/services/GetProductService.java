package br.com.learn.chenrique.spring_learn_jwt.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.learn.chenrique.spring_learn_jwt.exceptions.ProductNotFoundException;
import br.com.learn.chenrique.spring_learn_jwt.model.Product;
import br.com.learn.chenrique.spring_learn_jwt.model.dto.ProductDTO;
import br.com.learn.chenrique.spring_learn_jwt.repository.ProductRepository;

@Service
public class GetProductService implements Query<Integer, ProductDTO> {

    private final ProductRepository productRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(GetProductService.class);

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Cacheable("productCache")
    public ResponseEntity<ProductDTO> execute(Integer input) {

        LOGGER.info("Executando : " + getClass() + ". Input : " + input);
        Optional<Product> result = productRepository.findById(input);
        if (result.isPresent()) {
            return ResponseEntity.ok(new ProductDTO(result.get()));
        }

        throw new ProductNotFoundException();
    }

}
