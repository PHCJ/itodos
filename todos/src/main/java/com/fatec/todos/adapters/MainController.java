package com.fatec.todos.adapters;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/todos")
public class MainController {
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	@GetMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("admin/home");
	}
	@GetMapping("/accessibility")
	public ModelAndView acessibilidade() {
		return new ModelAndView("acessibilidade");
	}
	@GetMapping("/product")
	public ModelAndView produto() {
		return new ModelAndView("product");
	}
	@GetMapping("/about")
	public ModelAndView sobre() {
		return new ModelAndView("about");
	}
	@GetMapping("/contact")
	public ModelAndView contato() {
		return new ModelAndView("contact");
	}
	@GetMapping("/shoping-cart")
	public ModelAndView carrinho() {
		return new ModelAndView("shoping-cart");
	}
	
	@GetMapping("/female")
	public ModelAndView feminino() {
		return new ModelAndView("female");
	}
	
	@GetMapping("/male")
	public ModelAndView masculino() {
		return new ModelAndView("male");
	}
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
}
