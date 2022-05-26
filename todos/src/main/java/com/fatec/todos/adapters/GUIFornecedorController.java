package com.fatec.todos.adapters;

import com.fatec.todos.model.Fornecedor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/todos")
public class GUIFornecedorController {
    Logger logger = LogManager.getLogger(GUIFornecedorController.class);
    @GetMapping("/fornecedor")
	public ModelAndView retornaFormDeCadastroDeFornecedor(Fornecedor fornecedor) {
		ModelAndView mv = new ModelAndView("admin/cadastroFornecedor");
		mv.addObject("fornecedor", fornecedor);
		return mv;
	}
}
