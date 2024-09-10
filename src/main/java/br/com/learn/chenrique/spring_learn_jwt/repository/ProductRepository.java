package br.com.learn.chenrique.spring_learn_jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.learn.chenrique.spring_learn_jwt.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByNomeContaining(String nome);

    /*
     * Caso de query personalizada. Usamos o JPQL
     * 
     * @Query("SELECT ... FROM ... WHERE campo1 LIKE %:keyword%")
     */

    // EX. JPQL

    @Query("SELECT p FROM Product p WHERE p.nome LIKE %:key% OR p.descricao LIKE %:key%")
    List<Product> findByNomeOrDescricaoContaining(@Param("key") String key);
}
