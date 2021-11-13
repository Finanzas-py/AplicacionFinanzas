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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Rate")
public class Rate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRate;

	@Column(name = "name", length = 150, nullable = false)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "discountDate")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date discountDate;
	
	@Column(name = "days", length = 150, nullable = false)
	private int days;

	@Column(name = "rate", length = 150, nullable = false)
	private int rate;

	@ManyToOne
	@JoinColumn(name = "idCTermRate", nullable = true)
	private TermRate termRate;
	
	@ManyToOne
	@JoinColumn(name = "idCTermRateCapital", nullable = true)
	private TermRate termRateCapital;
	
	@ManyToOne
	@JoinColumn(name = "idRateType", nullable = true)
	private RateType RateType;
	
	
	public Rate() {
		super();
	}


	public Rate(int idRate, String name, Date discountDate, int days, int rate, TermRate termRate,
			TermRate termRateCapital, pe.edu.upc.spring.model.RateType rateType) {
		super();
		this.idRate = idRate;
		this.name = name;
		this.discountDate = discountDate;
		this.days = days;
		this.rate = rate;
		this.termRate = termRate;
		this.termRateCapital = termRateCapital;
		RateType = rateType;
	}


	public int getIdRate() {
		return idRate;
	}


	public void setIdRate(int idRate) {
		this.idRate = idRate;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDiscountDate() {
		return discountDate;
	}


	public void setDiscountDate(Date discountDate) {
		this.discountDate = discountDate;
	}


	public int getDays() {
		return days;
	}


	public void setDays(int days) {
		this.days = days;
	}


	public int getRate() {
		return rate;
	}


	public void setRate(int rate) {
		this.rate = rate;
	}


	public TermRate getTermRate() {
		return termRate;
	}


	public void setTermRate(TermRate termRate) {
		this.termRate = termRate;
	}


	public TermRate getTermRateCapital() {
		return termRateCapital;
	}


	public void setTermRateCapital(TermRate termRateCapital) {
		this.termRateCapital = termRateCapital;
	}


	public RateType getRateType() {
		return RateType;
	}


	public void setRateType(RateType rateType) {
		RateType = rateType;
	}



}
