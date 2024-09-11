package br.com.learn.chenrique.spring_learn_jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.learn.chenrique.spring_learn_jwt.model.Product;
import br.com.learn.chenrique.spring_learn_jwt.model.dto.ProductDTO;
import br.com.learn.chenrique.spring_learn_jwt.repository.ProductRepository;
import br.com.learn.chenrique.spring_learn_jwt.services.CreateProductService;

public class InsertProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private CreateProductService createProductService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void dado_produto_novo() {
        Product product = new Product();
        product.setId(1);
        product.setNome("Produto teste");
        product.setDescricao("Produto teste descricao");
        product.setPreco(9.99);

        // Simula a ação de salvar o produto
        when(productRepository.save(product)).thenReturn(product);

        // Act: Chama o serviço de criação
        ResponseEntity<ProductDTO> response = createProductService.execute(product);

        // Assert: Verifica se o retorno é o esperado

        assertEquals(ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(product)), response);

        // Verifica se o método save foi chamado corretamente
        verify(productRepository).save(product);

    }

}
