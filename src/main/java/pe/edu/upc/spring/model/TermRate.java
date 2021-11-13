package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "TermRate")
public class TermRate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTermRate;

	@Column(name = "termName", length = 150, nullable = false)
	private String termName;

	@Column(name = "num_days", length = 150, nullable = false)
	private int num_days;


	public TermRate() {
		super();
	}


	public TermRate(int idTermRate, String termName, int num_days) {
		super();
		this.idTermRate = idTermRate;
		this.termName = termName;
		this.num_days = num_days;
	}


	public int getIdTermRate() {
		return idTermRate;
	}


	public void setIdTermRate(int idTermRate) {
		this.idTermRate = idTermRate;
	}


	public String getTermName() {
		return termName;
	}


	public void setTermName(String termName) {
		this.termName = termName;
	}


	public int getNum_days() {
		return num_days;
	}


	public void setNum_days(int num_days) {
		this.num_days = num_days;
	}






}
