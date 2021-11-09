package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Company")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCompany;

	@Column(name = "compayName", length = 150, nullable = false)
	private String compayName;


	public Company() {
		super();
	}


	public Company(int idCompany, String compayName) {
		super();
		this.idCompany = idCompany;
		this.compayName = compayName;
	}


	public int getIdCompany() {
		return idCompany;
	}


	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}


	public String getCompayName() {
		return compayName;
	}


	public void setCompayName(String compayName) {
		this.compayName = compayName;
	}


	


}
