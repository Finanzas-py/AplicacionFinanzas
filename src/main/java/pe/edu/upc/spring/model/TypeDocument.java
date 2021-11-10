package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "TypeDocument")
public class TypeDocument implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTypeDocument;

	@Column(name = "name", length = 150, nullable = false)
	private String name;


	public TypeDocument() {
		super();
	}


	public TypeDocument(int idTypeDocument, String name) {
		super();
		this.idTypeDocument = idTypeDocument;
		this.name = name;
	}


	public int getIdTypeDocument() {
		return idTypeDocument;
	}


	public void setIdTypeDocument(int idTypeDocument) {
		this.idTypeDocument = idTypeDocument;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	

	


}
