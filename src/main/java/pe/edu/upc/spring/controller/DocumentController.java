package pe.edu.upc.spring.controller;

import java.util.ArrayList;
import java.util.Date;
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
import pe.edu.upc.spring.model.Rate;
import pe.edu.upc.spring.model.ReasonCf;
import pe.edu.upc.spring.model.ReasonCi;
import pe.edu.upc.spring.model.Users;
import pe.edu.upc.spring.service.ICompanyService;
import pe.edu.upc.spring.service.ICostService;
import pe.edu.upc.spring.service.IReasonCfService;
import pe.edu.upc.spring.service.IReasonCiService;
import pe.edu.upc.spring.service.ITermRateService;
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
	private IReasonCfService iReasonCfService;

	@Autowired
	private ITermRateService iTermRateService;


	private List<Cost> listCostCi;
	private List<Cost> listCostCf;
	private String idReasonCi;
	private String idReasonCf;

	@RequestMapping("/irRegistrarFactura")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("user", userController.sessionUser);
		model.addAttribute("listReasonCi", iReasonCiService.listReasonCi());
		model.addAttribute("listReasonCf", iReasonCfService.listReasonCf());
		model.addAttribute("listTermRate",iTermRateService.listTermRate());
		model.addAttribute("rate",new Rate());
		
		 listCostCi = null;
		 listCostCi= new ArrayList<Cost>();
		 listCostCf = null;
		 listCostCf= new ArrayList<Cost>();
		model.addAttribute("cost", new Cost());

		return "factura";
	}

	@RequestMapping("/iractualizarFactura")
	public String iractualizarFactura(Model model) {
		model.addAttribute("user", userController.sessionUser);
		model.addAttribute("listReasonCi", iReasonCiService.listReasonCi());
		model.addAttribute("listReasonCf", iReasonCfService.listReasonCf());
		model.addAttribute("listCostInitials", listCostCi);
		model.addAttribute("listCostFinals", listCostCf);
		model.addAttribute("listTermRate",iTermRateService.listTermRate());
		model.addAttribute("cost", new Cost());
		model.addAttribute("rate", new Rate());

		return "factura";
	}

	@RequestMapping("/registrarCostosIniciales")
	public String registrarCostoIniciales(@ModelAttribute Cost objCost, BindingResult binRes, Model model)
			throws ParseException {
		
		listCostCi.add(objCost);

		return "redirect:/document/iractualizarFactura";

	}
	
	@RequestMapping("/registrarCostosFinales")
	public String registrarCostoFinales(@ModelAttribute Cost objCost, BindingResult binRes, Model model)
			throws ParseException {
	
		listCostCf.add(objCost);

		return "redirect:/document/iractualizarFactura";

	}

	@RequestMapping("/prueba")
	public String  prueba(@ModelAttribute Rate objRate, BindingResult binRes, Model model)
			throws ParseException {
		
		System.out.println(objRate.getDiscountDate().toString());
		return "redirect:/document/iractualizarFactura";

	}
}
