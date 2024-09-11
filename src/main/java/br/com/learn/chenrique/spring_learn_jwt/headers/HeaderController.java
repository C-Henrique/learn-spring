package br.com.learn.chenrique.spring_learn_jwt.headers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.com.learn.chenrique.spring_learn_jwt.model.Product;
import br.com.learn.chenrique.spring_learn_jwt.model.dto.ProductDTO;

@RestController
public class HeaderController {

    @GetMapping("/header")
    public String getRegionResponse(@RequestHeader(required = false) String region) {

        if (region.equals("BR"))
            return "Teste região BR";

        if (region.equals("US"))
            return "Test region US";

        return "Country not suppported";
    }

    @GetMapping(value = "/header/product", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<ProductDTO> getProduct() {
        Product product = new Product();

        product.setId(1);
        product.setNome("Produto 1");
        product.setDescricao("Descricao produto 1");
        product.setPreco(9.99);

        return ResponseEntity.ok(new ProductDTO(product));
    }
}
