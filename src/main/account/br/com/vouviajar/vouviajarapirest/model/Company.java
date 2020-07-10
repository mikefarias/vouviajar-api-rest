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

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_company")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="id_user")
	private User idUser;
	
	@Column(name="name")
	private String name; 
	
	@Column(name="cnpj")
	private String cnpj;
	
	@OneToOne
	@JoinColumn(name="id_address")
	private Address address;

	@OneToOne
	@JoinColumn(name="id_company_contact")
	private CompanyContact companyContact;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="created_on")
	private OffsetDateTime createdOn;
	
	@Column(name="modified_on")
	private OffsetDateTime modifiedOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public User getIdUser() {
		return idUser;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public CompanyContact getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(CompanyContact companyContact) {
		this.companyContact = companyContact;
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
		result = prime * result + Objects.hash(address, cnpj, companyContact, createdOn, id, idUser, active,
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
				&& Objects.equals(companyContact, other.companyContact)
				&& Objects.equals(createdOn, other.createdOn) && Objects.equals(id, other.id)
				&& Objects.equals(idUser, other.idUser) && active == other.active
				&& Objects.equals(modifiedOn, other.modifiedOn) && Objects.equals(name, other.name);
	}

}