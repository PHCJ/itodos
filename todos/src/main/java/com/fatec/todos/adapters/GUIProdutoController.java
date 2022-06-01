package com.fatec.todos.adapters;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
	MantemProduto servico;

	@GetMapping("/produto")
	public ModelAndView retornaFormDeCadastroDeProduto(Produto produto) {
		ModelAndView mv = new ModelAndView("admin/cadastroProduto");
		mv.addObject("produto", produto);
		return mv;
	}

	@PostMapping("/produtos")
	public ModelAndView salvarProduto(@Valid Produto produto, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("admin/cadastroProduto");
		logger.info(produto.getCodBarras());
		logger.info(produto.getNome());
		logger.info(produto.getCor());
		logger.info(produto.getTamanho());
		logger.info(produto.getQuantidade());
		logger.info(produto.getCusto());
		if (result.hasErrors()) {
			modelAndView.setViewName("admin/home");
		} else {
			if (servico.salvarProduto(produto).isPresent()) {
				logger.info(">>>>>> controller chamou cadastrar e consulta todos");
				modelAndView.addObject("produtos", servico.consultarTodosOsProdutos());
			} else {
				logger.info(">>>>>> controller cadastrar com dados invalidos");
				modelAndView.setViewName("admin/cadastroProduto");
				modelAndView.addObject("message", "Dados invalidos");
			}
		}
		return modelAndView;
	}
	
	@GetMapping("/pesquisaProduto")
	public ModelAndView retornaFormDePesquisaDeProduto(Produto produto) {
		ModelAndView mv = new ModelAndView("admin/pesquisaProduto");
		mv.addObject("produto", produto);
		return mv;
	}

}
