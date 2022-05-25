package com.fatec.todos.adapters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.todos.model.Produto;

@Controller
@RequestMapping(path = "/todos")
public class GUIProdutoController {
	Logger logger = LogManager.getLogger(GUIProdutoController.class);
		
	@GetMapping("/produto")
	public ModelAndView retornaFormDeCadastroDeProduto(Produto produto) {
		ModelAndView mv = new ModelAndView("admin/cadastroProduto");
		mv.addObject("produto", produto);
		return mv;
	}

}
