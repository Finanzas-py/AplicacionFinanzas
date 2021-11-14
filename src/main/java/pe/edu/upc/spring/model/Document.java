package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Document")
public class Document implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDocument;

	@Column(name = "name", length = 150, nullable = false)
	private String name;


	@Column(name = "dateOfIssue", length = 150, nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfIssue;


	@Column(name = "paymentDate", length = 150, nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date paymentDate;

	
	@Column(name = "nominalValue", length = 150, nullable = false)
	private int nominalValue;

	@Column(name = "retention", length = 150, nullable = false)
	private int retention;
	
	@Column(name = "netValue", length = 150, nullable = false)
	private double netValue;
	
	@Column(name = "days", length = 150, nullable = false)
	private int days;
	
	@Column(name = "totalInitialCost", length = 150, nullable = false)
	private double totalInitialCost;
	
	@Column(name = "totalFinalCost", length = 150, nullable = false)
	private double totalFinalCost;
	
	@Column(name = "recivedValue", length = 150, nullable = false)
	private double recivedValue;
	
	@Column(name = "discountedRate", length = 150, nullable = false)
	private double discountedRate;
	
	@Column(name = "daysDiscount", length = 150, nullable = false)
	private float  daysDiscount;
	
	@Column(name = "TCEA", length = 150, nullable = false)
	private double  TCEA;
	
	@Column(name = "teD", length = 150, nullable = false)
	private double  teD;
	
	@ManyToOne
	@JoinColumn(name = "idUsers", nullable = false)
	private Users User;
	
	@OneToOne
	@JoinColumn(name = "idCompanyTransmitter", nullable = false)
	private Company CompanyTransmitter;
	
	@OneToOne
	@JoinColumn(name = "idCompanyReceiver", nullable = false)
	private Company CompanyReceiver;
	
	@OneToOne
	@JoinColumn(name = "idTypeDocument", nullable = false)
	private TypeDocument TypeDocument;
	
	@OneToOne
	@JoinColumn(name = "idCurrency", nullable = false)
	private Currency Currency;
	
	@ManyToOne
	@JoinColumn(name = "idPurse", nullable = false)
	private Purse Purse;
	
	
	public Document() {
		super();
	}


	public Document(int idDocument, String name, Date dateOfIssue, Date paymentDate, int nominalValue, int retention,
			double netValue, int days, double totalInitialCost, double totalFinalCost, double recivedValue,
			double discountedRate, float daysDiscount, double tCEA, double teD, Users user, Company companyTransmitter,
			Company companyReceiver, pe.edu.upc.spring.model.TypeDocument typeDocument,
			pe.edu.upc.spring.model.Currency currency, pe.edu.upc.spring.model.Purse purse) {
		super();
		this.idDocument = idDocument;
		this.name = name;
		this.dateOfIssue = dateOfIssue;
		this.paymentDate = paymentDate;
		this.nominalValue = nominalValue;
		this.retention = retention;
		this.netValue = netValue;
		this.days = days;
		this.totalInitialCost = totalInitialCost;
		this.totalFinalCost = totalFinalCost;
		this.recivedValue = recivedValue;
		this.discountedRate = discountedRate;
		this.daysDiscount = daysDiscount;
		TCEA = tCEA;
		this.teD = teD;
		User = user;
		CompanyTransmitter = companyTransmitter;
		CompanyReceiver = companyReceiver;
		TypeDocument = typeDocument;
		Currency = currency;
		Purse = purse;
	}


	public int getIdDocument() {
		return idDocument;
	}


	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDateOfIssue() {
		return dateOfIssue;
	}


	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public int getNominalValue() {
		return nominalValue;
	}


	public void setNominalValue(int nominalValue) {
		this.nominalValue = nominalValue;
	}


	public int getRetention() {
		return retention;
	}


	public void setRetention(int retention) {
		this.retention = retention;
	}


	public double getNetValue() {
		return netValue;
	}


	public void setNetValue(double netValue) {
		this.netValue = netValue;
	}


	public int getDays() {
		return days;
	}


	public void setDays(int days) {
		this.days = days;
	}


	public double getTotalInitialCost() {
		return totalInitialCost;
	}


	public void setTotalInitialCost(double totalInitialCost) {
		this.totalInitialCost = totalInitialCost;
	}


	public double getTotalFinalCost() {
		return totalFinalCost;
	}


	public void setTotalFinalCost(double totalFinalCost) {
		this.totalFinalCost = totalFinalCost;
	}


	public double getRecivedValue() {
		return recivedValue;
	}


	public void setRecivedValue(double recivedValue) {
		this.recivedValue = recivedValue;
	}


	public double getDiscountedRate() {
		return discountedRate;
	}


	public void setDiscountedRate(double discountedRate) {
		this.discountedRate = discountedRate;
	}


	public float getDaysDiscount() {
		return daysDiscount;
	}


	public void setDaysDiscount(float daysDiscount) {
		this.daysDiscount = daysDiscount;
	}


	public double getTCEA() {
		return TCEA;
	}


	public void setTCEA(double tCEA) {
		TCEA = tCEA;
	}


	public double getTeD() {
		return teD;
	}


	public void setTeD(double teD) {
		this.teD = teD;
	}


	public Users getUser() {
		return User;
	}


	public void setUser(Users user) {
		User = user;
	}


	public Company getCompanyTransmitter() {
		return CompanyTransmitter;
	}


	public void setCompanyTransmitter(Company companyTransmitter) {
		CompanyTransmitter = companyTransmitter;
	}


	public Company getCompanyReceiver() {
		return CompanyReceiver;
	}


	public void setCompanyReceiver(Company companyReceiver) {
		CompanyReceiver = companyReceiver;
	}


	public TypeDocument getTypeDocument() {
		return TypeDocument;
	}


	public void setTypeDocument(TypeDocument typeDocument) {
		TypeDocument = typeDocument;
	}


	public Currency getCurrency() {
		return Currency;
	}


	public void setCurrency(Currency currency) {
		Currency = currency;
	}


	public Purse getPurse() {
		return Purse;
	}


	public void setPurse(Purse purse) {
		Purse = purse;
	}





}
