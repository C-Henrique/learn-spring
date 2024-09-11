package br.com.learn.chenrique.spring_learn_jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.learn.chenrique.spring_learn_jwt.model.Customer;
import br.com.learn.chenrique.spring_learn_jwt.repository.CustomerRepository;

@RestController
@RequestMapping("/v2/cliente")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {

        return ResponseEntity.ok(customerRepository.findById(id).get());
    }
}
