package br.com.learn.chenrique.spring_learn_jwt.exceptions;

public enum ErrorMessages {
    PRODUCT_NOT_FOUND("Produto não encotrado!");

    private final String msg;

    ErrorMessages(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}
