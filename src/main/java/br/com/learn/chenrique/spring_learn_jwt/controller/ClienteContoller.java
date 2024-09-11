package br.com.learn.chenrique.spring_learn_jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.learn.chenrique.spring_learn_jwt.model.Cliente;
import br.com.learn.chenrique.spring_learn_jwt.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteContoller {

    private ClienteRepository clienteRepository;

    public ClienteContoller(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {

        return ResponseEntity.ok(clienteRepository.findById(id).get());
    }
}
