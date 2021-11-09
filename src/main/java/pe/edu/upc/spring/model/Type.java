package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Type")
public class Type implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idType;

	@Column(name = "name", length = 150, nullable = false)
	private String name;


	public Type() {
		super();
	}


	public Type(int idType, String name) {
		super();
		this.idType = idType;
		this.name = name;
	}


	public int getIdType() {
		return idType;
	}


	public void setIdType(int idType) {
		this.idType = idType;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




}
