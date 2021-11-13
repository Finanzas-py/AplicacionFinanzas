package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Purse")
public class Purse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPurse;

	@Column(name = "totalGivenAmount", length = 150, nullable = false)
	private double totalGivenAmount;

	@Column(name = "totalRecivedAmount", length = 150, nullable = false)
	private double totalRecivedAmount;

	@Column(name = "totalInitialCost", length = 150, nullable = false)
	private double totalInitialCost;

	@Column(name = "totalFinalCost", length = 150, nullable = false)
	private double totalFinalCost;

	@Column(name = "TCEA", length = 150, nullable = false)
	private double TCEA;

	@Column(name = "TIR", length = 150, nullable = false)
	private int TIR;


	public Purse() {
		super();
	}


	public Purse(int idPurse, double totalGivenAmount, double totalRecivedAmount, double totalInitialCost,
			double totalFinalCost, double tCEA, int tIR) {
		super();
		this.idPurse = idPurse;
		this.totalGivenAmount = totalGivenAmount;
		this.totalRecivedAmount = totalRecivedAmount;
		this.totalInitialCost = totalInitialCost;
		this.totalFinalCost = totalFinalCost;
		TCEA = tCEA;
		TIR = tIR;
	}


	public int getIdPurse() {
		return idPurse;
	}


	public void setIdPurse(int idPurse) {
		this.idPurse = idPurse;
	}


	public double getTotalGivenAmount() {
		return totalGivenAmount;
	}


	public void setTotalGivenAmount(double totalGivenAmount) {
		this.totalGivenAmount = totalGivenAmount;
	}


	public double getTotalRecivedAmount() {
		return totalRecivedAmount;
	}


	public void setTotalRecivedAmount(double totalRecivedAmount) {
		this.totalRecivedAmount = totalRecivedAmount;
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


	public double getTCEA() {
		return TCEA;
	}


	public void setTCEA(double tCEA) {
		TCEA = tCEA;
	}


	public int getTIR() {
		return TIR;
	}


	public void setTIR(int tIR) {
		TIR = tIR;
	}


	


}
