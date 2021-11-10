package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "ReasonCi")
public class ReasonCi implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReasonCi;

	@Column(name = "name", length = 150, nullable = false)
	private String name;


	public ReasonCi() {
		super();
	}


	public ReasonCi(int idReasonCi, String name) {
		super();
		this.idReasonCi = idReasonCi;
		this.name = name;
	}


	public int getIdReasonCi() {
		return idReasonCi;
	}


	public void setIdReasonCi(int idReasonCi) {
		this.idReasonCi = idReasonCi;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	


}
