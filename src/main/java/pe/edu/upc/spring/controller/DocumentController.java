package pe.edu.upc.spring.controller;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Cost;
import pe.edu.upc.spring.model.Document;
import pe.edu.upc.spring.model.Rate;
import pe.edu.upc.spring.model.RateType;
import pe.edu.upc.spring.model.ReasonCf;
import pe.edu.upc.spring.model.ReasonCi;
import pe.edu.upc.spring.model.TypeDocument;
import pe.edu.upc.spring.model.Users;
import pe.edu.upc.spring.service.ICompanyService;
import pe.edu.upc.spring.service.ICostService;
import pe.edu.upc.spring.service.IDocumentService;
import pe.edu.upc.spring.service.IRateService;
import pe.edu.upc.spring.service.IRateTypeService;
import pe.edu.upc.spring.service.IReasonCfService;
import pe.edu.upc.spring.service.IReasonCiService;
import pe.edu.upc.spring.service.ITermRateService;
import pe.edu.upc.spring.service.ITypeDocumentService;
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

	@Autowired
	private IRateTypeService iRateTypeService;

	@Autowired
	private IRateService iRateService;

	@Autowired
	private IDocumentService iDocumentService;

	@Autowired
	private ICostService iCostService;

	@Autowired
	private ITypeDocumentService iTypeDocumentService;

	private List<Cost> listCostCi;
	private List<Cost> listCostCf;
	private List<RateType> listRateType;
	private List<Cost> listCostEliminadosCf;
	private List<Cost> listCostEliminadosCi;

	private Rate rate;
	private Document document;
	private int resultados;
	private int tasa_factura;
	private int contador = 0;

	@RequestMapping("/irRegistrarFactura")
	public String irPaginaRegistrar(Model model) {
		tasa_factura = 1;
		contador = 0;
		resultados = 0;
		rate = null;
		rate = new Rate();
		document = new Document();
		listCostCi = null;
		listCostCi = new ArrayList<Cost>();
		listCostCf = null;
		listCostCf = new ArrayList<Cost>();
		listRateType = null;
		listRateType = new ArrayList<RateType>();
		listCostEliminadosCf = null;
		listCostEliminadosCf = new ArrayList<Cost>();
		listCostEliminadosCi = null;
		listCostEliminadosCi = new ArrayList<Cost>();
		model.addAttribute("user", userController.sessionUser);
		model.addAttribute("listReasonCi", iReasonCiService.listReasonCi());
		model.addAttribute("listReasonCf", iReasonCfService.listReasonCf());
		model.addAttribute("listTermRate", iTermRateService.listTermRate());
		model.addAttribute("listRateType", iRateTypeService.listRateType());

		model.addAttribute("listTermRateCapital", iTermRateService.listTermRate());
		model.addAttribute("tasa_factura", tasa_factura);
		model.addAttribute("rate", rate);
		model.addAttribute("document", document);
		model.addAttribute("resultados", resultados);
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
		model.addAttribute("listTermRateCapital", iTermRateService.listTermRate());
		model.addAttribute("listRateType", iRateTypeService.listRateType());
		model.addAttribute("tasa_factura", tasa_factura);
		model.addAttribute("cost", new Cost());
		model.addAttribute("rate", rate);
		model.addAttribute("resultados", resultados);
		model.addAttribute("document", document);

		return "factura";
	}

	@RequestMapping("/a")
	public String a(Model model) {
		if (tasa_factura == 1) {
			rate.setRateType(iRateTypeService.listRateType().get(1));
			tasa_factura = 2;

		} else {
			rate.setRateType(iRateTypeService.listRateType().get(0));
			tasa_factura = 1;
		}

		return "redirect:/document/iractualizarFactura";
	}

	@RequestMapping("/registrarCostosIniciales")
	public String registrarCostoIniciales(@ModelAttribute Cost objCost, BindingResult binRes, Model model)
			throws ParseException {

		objCost.setIdRef(contador);

		contador = contador + 1;

		listCostCi.add(objCost);

		return "redirect:/document/iractualizarFactura";

	}

	@RequestMapping("/registrarCostosFinales")
	public String registrarCostoFinales(@ModelAttribute Cost objCost, BindingResult binRes, Model model)
			throws ParseException {

		objCost.setIdRef(contador);

		contador = contador + 1;

		listCostCf.add(objCost);
		return "redirect:/document/iractualizarFactura";

	}

	@RequestMapping("/Modificar")
	public String modificar() throws ParseException {
		listCostCi = null;
		listCostCi = new ArrayList<Cost>();
		listCostCf = null;
		listCostCf = new ArrayList<Cost>();
		listCostEliminadosCf = null;
		listCostEliminadosCf = new ArrayList<Cost>();

		int max = iDocumentService.listDocument().size() - 1;
		Document d = iDocumentService.listDocument().get(max);
		int tamano = iCostService.listCost().size();

		for (int i = 0; i < tamano; i++) {
			Cost cost = iCostService.listCost().get(i);

			if (cost.getDocument().getIdDocument() - 1 == max && cost.isState() == false) { // CI
				cost.setIdRef(contador);
				listCostCi.add(cost);

			} else if (cost.getDocument().getIdDocument() - 1 == max && cost.isState() == true) {
				cost.setIdRef(contador);
				listCostCf.add(cost);
			}
			contador = contador + 1;
		}

		if (d.getRateDoc().getRateType().getIdRateType() == 1)
			tasa_factura = 1;
		else
			tasa_factura = 2;

		rate = d.getRateDoc();
		listCostEliminadosCf = null;
		listCostEliminadosCf = new ArrayList<Cost>();
		listCostEliminadosCi = null;
		listCostEliminadosCi = new ArrayList<Cost>();
		resultados = 0;
		document = d;

		return "redirect:/document/iractualizarFactura";

	}

	@RequestMapping("/CrearFactura")
	public String mostrar(@ModelAttribute Document objDocument, @ModelAttribute Rate objRate, BindingResult binRes,
			Model model) throws ParseException {

		resultados = 1;

		objDocument.setDays(calcularEdad(objDocument.getDateOfIssue(), objDocument.getPaymentDate()));

		int tasa_cap;
		double tasa; // TASA
		int dias = objDocument.getDays();
		double valor_nominal;
		double dias_tasa;
		double d;
		double ted;
		float D;
		int retencion;
		double CI = 0;
		double CF = 0;
		double valor_neto;
		double valor_recibido;
		double valor_total;
		double TCEA;

		if (tasa_factura == 1) { // calculo para tasa efectiva

			tasa = objRate.getRateNominal() / (double) 100;
			valor_nominal = objDocument.getNominalValue();
			dias_tasa = objRate.getTermRate().getNum_days();
			tasa = Math.pow(1 + tasa, objRate.getDays() / dias_tasa) - 1;
			objRate.setRate(tasa * 100);
			ted = Math.pow(1 + tasa, dias / (double) objRate.getDays()) - 1;

			objDocument.setTeD(ted);
			d = ted / (1 + ted);
			objDocument.setDiscountedRate(d); // d
			D = (float) (valor_nominal * d);
			objDocument.setDaysDiscount(D); // D
			retencion = objDocument.getRetention();

			for (int i = 0; i < listCostCi.size(); i++) {
				CI = CI + listCostCi.get(i).getAmount();
			}

			for (int i = 0; i < listCostCf.size(); i++) {
				CF = CF + listCostCf.get(i).getAmount();
			}

			DecimalFormat formato1 = new DecimalFormat("####.000000000");
			System.out.println(objDocument.getIdDocument());

			objDocument.setTotalInitialCost(CI);
			objDocument.setTotalFinalCost(CF);

			valor_neto = valor_nominal - D;
			objDocument.setNetValue(valor_neto);
			valor_recibido = valor_neto - retencion - CI;
			objDocument.setRecivedValue(valor_recibido);
			valor_total = valor_nominal - retencion + CF;
			objDocument.setValueTotal(valor_total);
			TCEA = Math.pow(valor_total / valor_recibido, objRate.getDays() / (double) dias) - 1;
			objDocument.setTCEA(TCEA);

			/////////////// REGISTRO EN LA BASE DE DATOS
			objDocument.setUser(userController.sessionUser);
			objDocument.setCompanyTransmitter(userController.sessionUser.getCompany());
			objDocument.setCompanyReceiver(userController.sessionUser.getCompany());

			objDocument.setIdDocument(document.getIdDocument());
			objRate.setIdRate(rate.getIdRate());
			boolean registro_exitoso_tasa = iRateService.save(objRate);

			if (registro_exitoso_tasa) {
				objDocument.setRateDoc(objRate);
				objDocument.setTypeDocument(iTypeDocumentService.listTypeDocument().get(0));
				boolean registro_exitoso_document = iDocumentService.save(objDocument);

				if (registro_exitoso_document) {

					for (int i = 0; i < listCostCi.size(); i++) { // elimina lista Ci
						Cost cost = listCostCi.get(i);
						if (cost.getDocument() != null) {
							iCostService.delete(cost.getIdCost());
						}
						System.out.println("ACTUALIZADO");
					}

					for (int i = 0; i < listCostCf.size(); i++) { // elimina lista Cf
						Cost cost = listCostCf.get(i);
						if (cost.getDocument() != null) {
							iCostService.delete(cost.getIdCost());
						}
						System.out.println("ACTUALIZADO");
					}

					int m = listCostEliminadosCf.size();
					for (int i = 0; i < m; i++) { // elimina registro de cf
						Cost cost = listCostEliminadosCf.get(i);
						if (cost.getDocument() != null) {
							iCostService.delete(cost.getIdCost());
						
						}

					}
					m = listCostEliminadosCi.size();
					for (int i = 0; i < m; i++) {  // elimina registro de cf
						Cost cost = listCostEliminadosCi.get(i);
						if (cost.getDocument() != null) {
							iCostService.delete(cost.getIdCost());
							
						}

					}

					for (int i = 0; i < listCostCi.size(); i++) {
						Cost cost = listCostCi.get(i);
						cost.setState(false);
						cost.setIdRef(0);
						cost.setDocument(objDocument);
						iCostService.save(cost);
					}

					for (int i = 0; i < listCostCf.size(); i++) {
						Cost cost = listCostCf.get(i);
						cost.setState(true);
						cost.setIdRef(0);
						cost.setDocument(objDocument);
						iCostService.save(cost);
					}

					System.out.println("REGISTRO EXITOSO");

				}

			}
			contador = 0;
			////////////
			document = objDocument;
			rate = objRate;

			// Operaciones que se mostraran en patanlla
			document.setTeD(ted * (double) 100);
			document.setDiscountedRate(d * (double) 100);
			document.setTCEA(TCEA * (double) 100);
		} else {
			tasa_cap = objRate.getTermRateCapital().getNum_days();
			valor_nominal = objDocument.getNominalValue();
			dias_tasa = objRate.getTermRate().getNum_days();
			tasa = objRate.getRateNominal() / (double) 100;
			tasa = Math.pow(1 + (tasa / (dias_tasa / (double) tasa_cap)), (objRate.getDays()) / (double) tasa_cap) - 1;
			objRate.setRate(tasa * 100);
			ted = Math.pow(1 + tasa, dias / (double) objRate.getDays()) - 1;
			objDocument.setTeD(ted);
			d = ted / (1 + ted);
			objDocument.setDiscountedRate(d); // d
			D = (float) (valor_nominal * d);
			objDocument.setDaysDiscount(D); // D
			retencion = objDocument.getRetention();

			for (int i = 0; i < listCostCi.size(); i++) {
				CI = CI + listCostCi.get(i).getAmount();
			}

			for (int i = 0; i < listCostCf.size(); i++) {
				CF = CF + listCostCf.get(i).getAmount();
			}

			objDocument.setTotalInitialCost(CI);
			objDocument.setTotalFinalCost(CF);

			valor_neto = valor_nominal - D;
			objDocument.setNetValue(valor_neto);
			valor_recibido = valor_neto - retencion - CI;
			objDocument.setRecivedValue(valor_recibido);
			valor_total = valor_nominal - retencion + CF;
			objDocument.setValueTotal(valor_total);
			TCEA = Math.pow(valor_total / valor_recibido, objRate.getDays() / (double) dias) - 1;
			objDocument.setTCEA(TCEA);

			DecimalFormat formato1 = new DecimalFormat("####.000000000");
			System.out.println(formato1.format(objDocument.getIdDocument()));

/////////////// REGISTRO EN LA BASE DE DATOS
			objDocument.setUser(userController.sessionUser);
			objDocument.setCompanyTransmitter(userController.sessionUser.getCompany());
			objDocument.setCompanyReceiver(userController.sessionUser.getCompany());

			objDocument.setIdDocument(document.getIdDocument());
			objRate.setIdRate(rate.getIdRate());
			boolean registro_exitoso_tasa = iRateService.save(objRate);

			if (registro_exitoso_tasa) {
				objDocument.setRateDoc(objRate);
				objDocument.setTypeDocument(iTypeDocumentService.listTypeDocument().get(0));
				boolean registro_exitoso_document = iDocumentService.save(objDocument);

				if (registro_exitoso_document) {

					for (int i = 0; i < listCostCi.size(); i++) { // elimina lista Ci
						Cost cost = listCostCi.get(i);
						if (cost.getDocument() != null) {
							iCostService.delete(cost.getIdCost());
						}
						System.out.println("ACTUALIZADO");
					}

					for (int i = 0; i < listCostCf.size(); i++) { // elimina lista Cf
						Cost cost = listCostCf.get(i);
						if (cost.getDocument() != null) {
							iCostService.delete(cost.getIdCost());
						}
						System.out.println("ACTUALIZADO");
					}

					int m = listCostEliminadosCf.size();
					for (int i = 0; i < m; i++) { // elimina registro de cf
						Cost cost = listCostEliminadosCf.get(i);
						if (cost.getDocument() != null) {
							iCostService.delete(cost.getIdCost());
						
						}

					}
					m = listCostEliminadosCi.size();
					for (int i = 0; i < m; i++) {  // elimina registro de cf
						Cost cost = listCostEliminadosCi.get(i);
						if (cost.getDocument() != null) {
							iCostService.delete(cost.getIdCost());
							
						}

					}

					for (int i = 0; i < listCostCi.size(); i++) {
						Cost cost = listCostCi.get(i);
						cost.setState(false);
						cost.setIdRef(0);
						cost.setDocument(objDocument);
						iCostService.save(cost);
					}

					for (int i = 0; i < listCostCf.size(); i++) {
						Cost cost = listCostCf.get(i);
						cost.setState(true);
						cost.setIdRef(0);
						cost.setDocument(objDocument);
						iCostService.save(cost);
					}

					System.out.println("REGISTRO EXITOSO");

				}

			}
			contador = 0;
			////////////
			document = objDocument;
			rate = objRate;

			// Operaciones que se mostraran en patanlla
			document.setTeD(ted * (double) 100);
			document.setDiscountedRate(d * (double) 100);
			document.setTCEA(TCEA * (double) 100);
		}

		return "redirect:/document/iractualizarFactura";

	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {

			int n = listCostCf.size();
			int m = listCostCi.size();
			System.out.println(n+"   "+m);
			if (id != null) {

				for (int i = 0; i < n; i++) {
					Cost cost = listCostCf.get(i);
					if (cost.getIdRef() == id) {
						listCostEliminadosCf.add(cost);
						listCostCf.remove(i);
						System.out.println("ELIMINADO EXITOSO");
					}
				}
				for (int i = 0; i < m; i++) {
					Cost cost = listCostCi.get(i);
					if (cost.getIdRef() == id) {
						listCostEliminadosCi.add(cost);
						listCostCi.remove(i);
						System.out.println("ELIMINADO EXITOSO");
					}
				}

			}
		} catch (Exception ex) {

		}
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
