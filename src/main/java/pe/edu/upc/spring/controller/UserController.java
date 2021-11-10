package pe.edu.upc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.parser.ParseException;


import pe.edu.upc.spring.model.Users;
import pe.edu.upc.spring.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService uService;
	

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Users objUser, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "user";
		} else {
			boolean flag = uService.save(objUser);
			if (flag) {
				
				return "redirect:/user/bienvenidoUser";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/user/irRegistrar";
			}
		}
	}

	
}
