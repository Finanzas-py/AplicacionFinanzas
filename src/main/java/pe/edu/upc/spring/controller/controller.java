package pe.edu.upc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pantalla") 
public class controller {
	
	@RequestMapping("/inicio")
	public String PaginaBienvenida(Model model) {
		return "bienvenido"; 
	}
	


	
}
