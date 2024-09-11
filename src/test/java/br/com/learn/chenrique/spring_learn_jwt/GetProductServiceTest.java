package br.com.learn.chenrique.spring_learn_jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import br.com.learn.chenrique.spring_learn_jwt.exceptions.ProductNotFoundException;
import br.com.learn.chenrique.spring_learn_jwt.model.Product;
import br.com.learn.chenrique.spring_learn_jwt.model.dto.ProductDTO;
import br.com.learn.chenrique.spring_learn_jwt.repository.ProductRepository;
import br.com.learn.chenrique.spring_learn_jwt.services.GetProductService;

public class GetProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private GetProductService getProductService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_product_exists_when_get_product_service_return_product_dto() {

        Product product = new Product();
        product.setId(1);
        product.setNome("Produto teste");
        product.setDescricao("Produto teste descricao");
        product.setPreco(9.99);

        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        ResponseEntity<ProductDTO> response = getProductService.execute(1);

        assertEquals(ResponseEntity.ok(new ProductDTO(product)), response);

        verify(productRepository, times(1)).findById(1);
    }

    @Test
    public void given_product_not_exist_when_get_product_service_throw_product_not_found_exception() {

        when(productRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> getProductService.execute(1));

        verify(productRepository, times(1)).findById(1);

    }
}
