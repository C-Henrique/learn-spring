package br.com.learn.chenrique.spring_learn_jwt.model.dto;

import br.com.learn.chenrique.spring_learn_jwt.model.Product;
import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;
    private String nome;
    private String descricao;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.descricao = product.getDescricao();
        this.nome = product.getNome();
    }

}
