package pe.edu.upc.spring.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
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
import pe.edu.upc.spring.model.Document;
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
	private Rate rate;
	private Document document;
	@RequestMapping("/irRegistrarFactura")
	public String irPaginaRegistrar(Model model) {
		rate = null;
		rate = new Rate();
		document = new Document();
		listCostCi = null;
		listCostCi = new ArrayList<Cost>();
		listCostCf = null;
		listCostCf = new ArrayList<Cost>();
		model.addAttribute("user", userController.sessionUser);
		model.addAttribute("listReasonCi", iReasonCiService.listReasonCi());
		model.addAttribute("listReasonCf", iReasonCfService.listReasonCf());
		model.addAttribute("listTermRate", iTermRateService.listTermRate());
		model.addAttribute("rate", rate);
		model.addAttribute("document", document);

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
		model.addAttribute("listTermRate", iTermRateService.listTermRate());
		model.addAttribute("cost", new Cost());
		model.addAttribute("rate", rate);
		model.addAttribute("document", document);
		
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
	public String prueba(@ModelAttribute Document objDocument, BindingResult binRes, Model model) throws ParseException {

		document = objDocument;
		int Dias = calcularEdad(objDocument.getDateOfIssue(),objDocument.getPaymentDate());
		System.out.println(Dias);
		return "redirect:/document/iractualizarFactura";

	}
	
	@RequestMapping("/mostrar")
	public String mostrar(@ModelAttribute Document objDocument,@ModelAttribute Rate objRate
			, BindingResult binRes, Model model) throws ParseException {

		document = objDocument;
		rate = objRate;
		int Dias = calcularEdad(objDocument.getDateOfIssue(),objDocument.getPaymentDate());
		Date fecha = objRate.getDiscountDate();
		System.out.println(Dias+"           "+fecha.toString());
		return "redirect:/document/iractualizarFactura";

	}
	
	public int calcularEdad(Date dateOfIssue, Date paymentDate) {
		Calendar fecha1 = Calendar.getInstance();
		Calendar fecha2 = Calendar.getInstance();
		fecha1.setTime(dateOfIssue);
		fecha2.setTime(paymentDate);
		int y1 = fecha1.get(Calendar.YEAR);
		int m1 = fecha1.get(Calendar.MONTH);
		int d1 = fecha1.get(Calendar.DAY_OF_MONTH);
		int y2 = fecha2.get(Calendar.YEAR);
		int m2 = fecha2.get(Calendar.MONTH);
		int d2 = fecha2.get(Calendar.DAY_OF_MONTH);
	
		LocalDate fechaemision = LocalDate.of(y1, m1, d1);
		LocalDate fechaPago = LocalDate.of(y2, m2, d2);
		Period periodo = Period.between(fechaemision, fechaPago);
		return periodo.getDays();
	}
}
