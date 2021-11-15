package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cost")
public class Cost implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCost;

	@Column(name = "amount", length = 150, nullable = false)
	private int amount;

	@ManyToOne
	@JoinColumn(name = "idReasonCi", nullable = true)
	private ReasonCi reasonCi;
	
	@ManyToOne
	@JoinColumn(name = "idReasonCf", nullable = true)
	private ReasonCf reasonCf;

	@Column(name = "state", length = 150, nullable = false)
	private boolean state;	


	public Cost() {
		super();
	}


	public Cost(int idCost, int amount, ReasonCi reasonCi, ReasonCf reasonCf, boolean state) {
		super();
		this.idCost = idCost;
		this.amount = amount;
		this.reasonCi = reasonCi;
		this.reasonCf = reasonCf;
		this.state = state;
	}


	public int getIdCost() {
		return idCost;
	}


	public void setIdCost(int idCost) {
		this.idCost = idCost;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public ReasonCi getReasonCi() {
		return reasonCi;
	}


	public void setReasonCi(ReasonCi reasonCi) {
		this.reasonCi = reasonCi;
	}


	public ReasonCf getReasonCf() {
		return reasonCf;
	}


	public void setReasonCf(ReasonCf reasonCf) {
		this.reasonCf = reasonCf;
	}


	public boolean isState() {
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	}



	


}
