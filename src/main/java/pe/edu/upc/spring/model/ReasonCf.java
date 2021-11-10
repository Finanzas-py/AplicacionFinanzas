package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "ReasonCf")
public class ReasonCf implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReasonCf;

	@Column(name = "name", length = 150, nullable = false)
	private String name;


	public ReasonCf() {
		super();
	}


	public ReasonCf(int idReasonCf, String name) {
		super();
		this.idReasonCf = idReasonCf;
		this.name = name;
	}


	public int getIdReasonCf() {
		return idReasonCf;
	}


	public void setIdReasonCf(int idReasonCf) {
		this.idReasonCf = idReasonCf;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




	


}
