package br.com.learn.chenrique.spring_learn_jwt.catfact;

import lombok.Data;

@Data
public class CatFactResponse {

    private String fact;
    private int length;
}
