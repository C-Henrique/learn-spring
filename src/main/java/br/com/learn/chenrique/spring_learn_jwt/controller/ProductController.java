package br.com.learn.chenrique.spring_learn_jwt.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.learn.chenrique.spring_learn_jwt.model.Product;
import br.com.learn.chenrique.spring_learn_jwt.model.dto.ProductDTO;
import br.com.learn.chenrique.spring_learn_jwt.services.CreateProductService;
import br.com.learn.chenrique.spring_learn_jwt.services.DeleteProductService;
import br.com.learn.chenrique.spring_learn_jwt.services.GetProductService;
import br.com.learn.chenrique.spring_learn_jwt.services.GetProductsService;
import br.com.learn.chenrique.spring_learn_jwt.services.SearchProductService;
import br.com.learn.chenrique.spring_learn_jwt.services.UpdateProductCommand;
import br.com.learn.chenrique.spring_learn_jwt.services.UpdateProductService;

@RestController
public class ProductController {

    private final CreateProductService createProductService;
    private final GetProductsService getProductsService;
    private final GetProductService getProductService;
    private final DeleteProductService deleteProductService;
    private final UpdateProductService updateProductService;
    private final SearchProductService searchProductService;

    public ProductController(CreateProductService createProductService, GetProductsService getProductsService,
            DeleteProductService deleteProductService, UpdateProductService updateProductService,
            GetProductService getProductService, SearchProductService searchProductService) {
        this.createProductService = createProductService;
        this.getProductsService = getProductsService;
        this.deleteProductService = deleteProductService;
        this.updateProductService = updateProductService;
        this.getProductService = getProductService;
        this.searchProductService = searchProductService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return getProductsService.execute(null);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getFindById(@PathVariable Integer id) {
        return getProductService.execute(id);
    }

    @GetMapping("/product/search")
    public ResponseEntity<List<ProductDTO>> searchProductByName(@RequestParam String nome) {
        return searchProductService.execute(nome);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        return createProductService.execute(product);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> putProduct(@PathVariable Integer id, @RequestBody Product product) {
        return updateProductService.execute(new UpdateProductCommand(id, product));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        return deleteProductService.execute(id);
    }
}
