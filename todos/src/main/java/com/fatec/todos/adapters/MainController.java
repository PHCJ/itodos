package com.fatec.todos.adapters;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@GetMapping("/admin")
	public String AcessarPrincipal() {
		return "admin/home";
	}
	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}
}
