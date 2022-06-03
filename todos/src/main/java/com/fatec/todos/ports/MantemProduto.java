package com.fatec.todos.ports;

import java.util.List;
import java.util.Optional;

import com.fatec.todos.model.Produto;

public interface MantemProduto {
	List<Produto> consultarTodosOsProdutos();
	Optional<Produto> consultaPorId(String id);
	Optional<Produto> consultaPorCodBarras(String codBarras);
	Optional<Produto> salvarProduto(Produto produto);
	Optional<Produto> atualizarProduto(Produto produto);
	void excluirProduto(String id);
	//Optional<Produto> desativarProduto(Produto produto);
	//Optional<Produto> ativarProduto(Produto produto);
}
	