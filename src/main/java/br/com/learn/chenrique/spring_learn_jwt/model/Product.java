package br.com.learn.chenrique.spring_learn_jwt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Adicione um nome.")
    private String nome;
    @Size(min = 20, message = "Descrição deve conter no minimo 20 caracteres.")
    private String descricao;
    @PositiveOrZero(message = "O valor não deve ser negativo.")
    private Double preco;

}
