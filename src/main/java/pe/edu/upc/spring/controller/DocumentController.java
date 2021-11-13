package pe.edu.upc.spring.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Cost;
import pe.edu.upc.spring.model.ReasonCi;
import pe.edu.upc.spring.model.Users;
import pe.edu.upc.spring.service.ICompanyService;
import pe.edu.upc.spring.service.ICostService;
import pe.edu.upc.spring.service.IReasonCiService;
import pe.edu.upc.spring.service.ITypeService;
import pe.edu.upc.spring.service.IUserService;

@Controller
@RequestMapping("/document")
public class DocumentController {

	@Autowired
	private UserController userController;

	@Autowired
	private IReasonCiService iReasonCiService;

	
	@Autowired
	private ICostService iCostService;

	private List<Cost> listCostCi = new ArrayList<Cost>();
	private String idReasonCi;
	
	@RequestMapping("/irRegistrarFactura")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("user", userController.sessionUser);
		model.addAttribute("listReasonCi",iReasonCiService.listReasonCi());
		
		model.addAttribute("cost",new Cost());

		return "factura";
	}
	
	@RequestMapping("/iractualizarFactura")
	public String iractualizarFactura(Model model) {
		model.addAttribute("user", userController.sessionUser);
		model.addAttribute("listReasonCi",iReasonCiService.listReasonCi());
		model.addAttribute("listCostInitials",listCostCi);
		model.addAttribute("cost",new Cost());

		return "factura";
	}
	
	@RequestMapping("/registrarCostosIniciales")
	public String registrarCostoIniciales(@ModelAttribute Cost objCost, BindingResult binRes, Model model)
			throws ParseException {
		 idReasonCi = String.valueOf(objCost.getReasonCi().getIdReasonCi());
		 List<ReasonCi> prueba = iReasonCiService.SearchById(idReasonCi);
		 objCost.setReasonCi(prueba.get(0));
		listCostCi.add(objCost);
		
			for (int i =0; i<listCostCi.size(); i++) {
				Cost n =listCostCi.get(i);
			}
		
			
			return "redirect:/document/iractualizarFactura";
		
	}



}
