package com.fatec.todos.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.todos.model.Produto;
import com.fatec.todos.ports.MantemProduto;
import com.fatec.todos.ports.ProdutoRepository;

@Service
public class MantemProdutoI implements MantemProduto{
	Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<Produto> consultarTodosOsProdutos() {
		logger.info(">>>> consultarTodosOsProdutos solicitado");
		return this.produtoRepository
				.findAll();
	}
	
	@Override
	public Optional<Produto> consultaPorId(String id) {
		logger.info(">>>> consultaPorId solicitado");
		return this.produtoRepository
				.findById(id);
	}

	@Override
	public Optional<Produto> consultaPorCodBarras(String codBarras) {
		logger.info(">>>> consultaPorCodBarras solicitado");
		return produtoRepository.findByCodBarras(codBarras);
	}

	@Override
	public Optional<Produto> salvarProduto(Produto produto) {
		logger.info(">>>> salvarProduto solicitado");
		
		Optional<Produto> umProduto = consultaPorCodBarras(produto.getCodBarras());

		if (umProduto.isEmpty()) {
			logger.info(">>>>>> servico salvarProduto - dados valido");
			return Optional.ofNullable(produtoRepository.save(produto));
		}else
			return Optional.empty();
	}
	
	@Override
	public Optional<Produto> atualizarProduto(Produto produto) {
		logger.info(">>>> atualizarProduto");
		Optional<Produto> umProduto = consultaPorId(produto.getId());
		if(umProduto.isPresent()) {
			return Optional.ofNullable(produtoRepository.save(produto));
		}
		else
			return Optional.empty();
	}

	@Override
	public void excluirProduto(String id) {
		logger.info(">>>> excluirProduto");
		produtoRepository.deleteById(id);
	}
	
	
}
