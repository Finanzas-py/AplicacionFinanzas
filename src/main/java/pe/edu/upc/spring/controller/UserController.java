package pe.edu.upc.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Users;
import pe.edu.upc.spring.service.ICompanyService;
import pe.edu.upc.spring.service.ITypeService;
import pe.edu.upc.spring.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService uService;

	@Autowired
	private ITypeService tService;

	@Autowired
	private ICompanyService cService;

	public Users sessionUser;

	@RequestMapping("/inicio")
	public String PaginaBienvenida(Model model) {
		model.addAttribute("user", sessionUser);
		return "bienvenidoUser";
	}

	@RequestMapping("/login")
	public String PaginaLogin(Model model) {
		model.addAttribute("user", new Users());
		return "userLogin";
	}

	@RequestMapping("/menu")
	public String PaginaMenu() {

		return "userMenu";
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("user", new Users());
		model.addAttribute("listCompany", cService.listCompany());
		model.addAttribute("listType", tService.listType());

		return "users";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute("user") @Valid Users objUser, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listCompany", cService.listCompany());
			model.addAttribute("listType", tService.listType());
			return "users";
		} else {
			boolean flag = uService.save(objUser);
			if (flag) {
				sessionUser = objUser;
				return "redirect:/user/inicio";
			} else {
				return "redirect:/user/irRegistrar";
			}
		}
	}

	@RequestMapping("/validarUsuario")
	public String ingresarCuenta(@ModelAttribute("user") @Valid Users objUser, BindingResult binRes) throws ParseException {

		List<Users> listUsers;
		objUser.setEmail(objUser.getEmail());
		objUser.setPassword(objUser.getPassword());
		listUsers = uService.findByEmailAndPassword(objUser.getEmail(), objUser.getPassword());
		
		
		
			if (!listUsers.isEmpty()) {
				objUser = listUsers.get(0);
				sessionUser = objUser;
				return "redirect:/user/inicio";
			} else {
				return "redirect:/user/login";
			}
		}
	
}
