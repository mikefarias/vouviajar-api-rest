package br.com.vouviajar.vouviajarapirest.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="company", schema="vouviajar")
public class Company implements Serializable{
	
	public Company(){	
	}

	public Company(String name, String phoneNumber, User user){	
		this.name = name; 
		this.phoneNumber = phoneNumber;
		this.user = user;
	}

	public Company(User user, String name, String phoneNumber, boolean active, OffsetDateTime createdOn,
			OffsetDateTime modifiedOn) {
		this.user = user;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.active = active;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_company", nullable = false)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="id_user", nullable = false)
	private User user;
	
	@Column(name="name", nullable = false)
	private String name; 
	
	@Column(name="cnpj")
	private String cnpj;
	
	@Column(name="phone_number", nullable = false)
	private String phoneNumber;

	@OneToOne
	@JoinColumn(name="id_address")
	private Address address;

	@Column(name="active", nullable = false)
	private boolean active;
	
	@Column(name="created_on", nullable = false)
	private OffsetDateTime createdOn;
	
	@Column(name="modified_on", nullable = false)
	private OffsetDateTime modifiedOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public OffsetDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(OffsetDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public OffsetDateTime getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(OffsetDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Objects.hash(address, cnpj, phoneNumber, createdOn, id, user, active,
				modifiedOn, name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return Objects.equals(address, other.address) && Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(createdOn, other.createdOn) && Objects.equals(id, other.id)
				&& Objects.equals(user, other.user) && active == other.active
				&& Objects.equals(modifiedOn, other.modifiedOn) 
				&& Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber);
	}
}