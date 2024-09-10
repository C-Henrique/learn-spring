package br.com.learn.chenrique.spring_learn_jwt.exceptions;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

}
