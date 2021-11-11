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

import net.bytebuddy.implementation.bind.annotation.Default;

@Entity
@Table(name = "Users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsers;

	@Column(name = "name", length = 150, nullable = false)
	private String name;
	
	@Column(name = "lastName", length = 150, nullable = false)
	private String lastName;
	
	@Column(name = "email", length = 60, nullable = false)
	private String email;
	

	@Column(name = "password", length = 20, nullable = false)
	private String password;

	
	@Column(name = "phoneNumber", length = 60, nullable = false)
	private String phoneNumber;
	
	
	@ManyToOne
	@JoinColumn(name = "idCompany", nullable = true)
	private Company company;
	
	@ManyToOne
	@JoinColumn(name = "idType", nullable = false)
	private Type type;
	
	@Column(name = "type_text", length = 20, nullable = false)
	private String type_text;

	public Users() {
		super();
	}

	public Users(int idUsers, String name, String lastName, String email, String password, String phoneNumber,
			Company company, Type type, String type_text) {
		super();
		this.idUsers = idUsers;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.company = company;
		this.type = type;
		this.type_text = type_text;
	}

	public int getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getType_text() {
		return type_text;
	}

	public void setType_text(String type_text) {
		this.type_text = type_text;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	






}
