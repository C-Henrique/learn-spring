package br.com.learn.chenrique.spring_learn_jwt.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductNotFoundException.class);

    public ProductNotFoundException() {

        super(ErrorMessages.PRODUCT_NOT_FOUND.getMsg());
        LOGGER.error("Erro : " + getClass() + " : " + getLocalizedMessage(), getCause());
    }
}
