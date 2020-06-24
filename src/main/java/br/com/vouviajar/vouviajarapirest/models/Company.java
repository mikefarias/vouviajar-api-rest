package br.com.vouviajar.vouviajarapirest.models;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY", schema = "vouviajar")
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_COMPANY")
	private Long idCompany;
	
	@OneToOne
	@JoinColumn(name = "ID_USER")
	private User idUser;
	
	@Column(name = "NAME")
	private String name; 
	
	@Column(name = "CNPJ")
	private String cnpj;
	
	@OneToOne
	@JoinColumn(name = "ID_ADDRESS")
	private Address address;

	@OneToOne
	@JoinColumn(name = "ID_TRAVEL_AGENCY")
	private TravelAgency travelAgency;

	@OneToOne
	@JoinColumn(name = "ID_CONTACT_TRAVEL_AGENCY")
	private TravelAgencyContact contactTravelAgency;
	
	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	
	@Column(name = "CREATED_ON")
	private OffsetDateTime createdOn;
	
	@Column(name = "MODIFIED_ON")
	private OffsetDateTime modifiedOn;

	public Long getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
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

	public TravelAgency getTravelAgency() {
		return travelAgency;
	}

	public void setTravelAgency(TravelAgency travelAgency) {
		this.travelAgency = travelAgency;
	}

	public TravelAgencyContact getContactTravelAgency() {
		return contactTravelAgency;
	}

	public void setContactTravelAgency(TravelAgencyContact contactTravelAgency) {
		this.contactTravelAgency = contactTravelAgency;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
		result = prime * result + Objects.hash(address, cnpj, contactTravelAgency, createdOn, idCompany, idUser, isActive,
				modifiedOn, name, travelAgency);
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
				&& Objects.equals(contactTravelAgency, other.contactTravelAgency)
				&& Objects.equals(createdOn, other.createdOn) && Objects.equals(idCompany, other.idCompany)
				&& Objects.equals(idUser, other.idUser) && isActive == other.isActive
				&& Objects.equals(modifiedOn, other.modifiedOn) && Objects.equals(name, other.name)
				&& Objects.equals(travelAgency, other.travelAgency);
	}

}
