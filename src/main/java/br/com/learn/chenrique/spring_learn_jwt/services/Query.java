package br.com.learn.chenrique.spring_learn_jwt.services;

import org.springframework.http.ResponseEntity;

public interface Query<I, O> {
    ResponseEntity<O> execute(I input);
}
