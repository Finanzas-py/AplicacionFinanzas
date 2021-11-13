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
import pe.edu.upc.spring.model.ReasonCf;
import pe.edu.upc.spring.model.ReasonCi;
import pe.edu.upc.spring.model.Users;
import pe.edu.upc.spring.service.ICompanyService;
import pe.edu.upc.spring.service.ICostService;
import pe.edu.upc.spring.service.IReasonCfService;
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
	private IReasonCfService iReasonCfService;


	private List<Cost> listCostCi;
	private List<Cost> listCostCf;
	private String idReasonCi;
	private String idReasonCf;

	@RequestMapping("/irRegistrarFactura")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("user", userController.sessionUser);
		model.addAttribute("listReasonCi", iReasonCiService.listReasonCi());
		model.addAttribute("listReasonCf", iReasonCfService.listReasonCf());
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

		model.addAttribute("cost", new Cost());

		return "factura";
	}

	@RequestMapping("/registrarCostosIniciales")
	public String registrarCostoIniciales(@ModelAttribute Cost objCost, BindingResult binRes, Model model)
			throws ParseException {
		idReasonCi = String.valueOf(objCost.getReasonCi().getIdReasonCi());
		List<ReasonCi> prueba = iReasonCiService.SearchById(idReasonCi);
		objCost.setReasonCi(prueba.get(0));
		listCostCi.add(objCost);

		return "redirect:/document/iractualizarFactura";

	}
	
	@RequestMapping("/registrarCostosFinales")
	public String registrarCostoFinales(@ModelAttribute Cost objCost, BindingResult binRes, Model model)
			throws ParseException {
		idReasonCf = String.valueOf(objCost.getReasonCf().getIdReasonCf());
		List<ReasonCf> prueba = iReasonCfService.SearchById(idReasonCf);
		objCost.setReasonCf(prueba.get(0));
		listCostCf.add(objCost);

		return "redirect:/document/iractualizarFactura";

	}

}
