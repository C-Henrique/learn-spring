package br.com.learn.chenrique.spring_learn_jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringLearnJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnJwtApplication.class, args);
	}

}
