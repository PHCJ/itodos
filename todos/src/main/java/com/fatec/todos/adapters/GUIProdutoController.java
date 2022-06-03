package com.fatec.todos.adapters;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.todos.model.Produto;
import com.fatec.todos.ports.MantemProduto;

@Controller
@RequestMapping(path = "/todos")
public class GUIProdutoController {
	Logger logger = LogManager.getLogger(GUIProdutoController.class);

	@Autowired
	MantemProduto mantemProduto;

	@GetMapping("/produto")
	public ModelAndView retornaFormDeCadastroDeProduto(Produto produto) {
		ModelAndView mv = new ModelAndView("admin/cadastroProduto");
		mv.addObject("produto", produto);
		return mv;
	}

	@GetMapping("/produtos")
	public ModelAndView retornaFormDeConsultaTodosProdutos() {
		ModelAndView modelAndView = new ModelAndView("admin/consultaProduto");
		modelAndView.addObject("produtos", mantemProduto.consultarTodosOsProdutos());
		return modelAndView;
	}
	
	@GetMapping("/produtos/id/{id}")
	public ModelAndView excluirNoFormDeConsultaProduto(@PathVariable("id") String id) {
		logger.info(">>>>>> servico de exclusao chamado para o id => " + id);
		mantemProduto.excluirProduto(id);
		ModelAndView modelAndView = new ModelAndView("admin/consultaProduto");
		modelAndView.addObject("produtos", mantemProduto.consultarTodosOsProdutos());
		return modelAndView;
	}
	
	@GetMapping("/produtos/{codBarras}")
	public ModelAndView retornaFormParaEditarProduto(@PathVariable("codBarras") String codBarras) {
		ModelAndView modelAndView = new ModelAndView("admin/atualizarProduto");
		modelAndView.addObject("produto", mantemProduto.consultaPorCodBarras(codBarras).get());
		return modelAndView;
	}

	@PostMapping("/produtos")
	public ModelAndView salvarProduto(@Valid Produto produto, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("admin/cadastroProduto");
		if (result.hasErrors()) {
			modelAndView.setViewName("admin/home");
		} else {
			if (mantemProduto.salvarProduto(produto).isPresent()) {
				logger.info(">>>>>> controller chamou cadastrar e consulta todos");
				modelAndView.addObject("produtos", mantemProduto.consultarTodosOsProdutos());
			} else {
				logger.info(">>>>>> controller cadastrar com dados invalidos");
				modelAndView.setViewName("admin/cadastroProduto");
				modelAndView.addObject("message", "Dados invalidos");
			}
		}
		return modelAndView;
	}
	
	@PostMapping("/produtos/id/{id}")
	public ModelAndView atualizaProduto(@PathVariable("id") String id, @Valid Produto produto, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("admin/consultaProduto");
		logger.info(">>>>>> servico para atualizacao de dados chamado para o id => " + id);
		if (result.hasErrors()) {
			logger.info(">>>>>> servico para atualizacao de dados com erro => " + result.getFieldError().toString());
			produto.setId(id);
			return new ModelAndView("admin/atualizarProduto");
		} else {
			mantemProduto.atualizarProduto(produto);
			modelAndView.addObject("produtos", mantemProduto.consultarTodosOsProdutos());
		}
		return modelAndView;
	}
	
}
