package br.com.learn.chenrique.spring_learn_jwt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {

        super(ErrorMessages.PRODUCT_NOT_FOUND.getMsg());
    }
}
