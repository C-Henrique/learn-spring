package br.com.learn.chenrique.spring_learn_jwt.services;

import br.com.learn.chenrique.spring_learn_jwt.model.Product;
import lombok.Getter;

@Getter
public class UpdateProductCommand {

    private Integer id;
    private Product product;

    public UpdateProductCommand(Integer id, Product product) {
        this.id = id;
        this.product = product;
    }

}