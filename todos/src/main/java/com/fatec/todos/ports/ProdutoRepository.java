package com.fatec.todos.ports;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fatec.todos.model.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String>{
	Optional<Produto>findByCodBarras(String codBarras);
}
