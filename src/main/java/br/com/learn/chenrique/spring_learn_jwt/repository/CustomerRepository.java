package br.com.learn.chenrique.spring_learn_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.learn.chenrique.spring_learn_jwt.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
