package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Currency")
public class Currency implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurrency;

	@Column(name = "name", length = 150, nullable = false)
	private String name;


	public Currency() {
		super();
	}


	public Currency(int idCurrency, String name) {
		super();
		this.idCurrency = idCurrency;
		this.name = name;
	}


	public int getIdCurrency() {
		return idCurrency;
	}


	public void setIdCurrency(int idCurrency) {
		this.idCurrency = idCurrency;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	


}
