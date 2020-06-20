package com.example.vouviajarapirest.models;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY", schema = "VOU_VIAJAR")
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_USER")
	private Long id;
	
	@Column(name = "NAME")
	private String name; 
	
	@Column(name = "CNPJ")
	private String cnpj;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "LOGO", columnDefinition="BLOB")
	private byte[] logo;
	
	@Column(name = "ADDRESS")
	private Address address;
	
	@Column(name = "CONTACT_TRAVEL_AGENCY")
	private ContactTravelAgency contactTravelAgency;
	
	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	
	@Column(name = "CREATED_ON")
	private OffsetDateTime createdOn;
	
	@Column(name = "CREATED_ON")
	private OffsetDateTime modifiedOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ContactTravelAgency getContactTravelAgency() {
		return contactTravelAgency;
	}

	public void setContactTravelAgency(ContactTravelAgency contactTravelAgency) {
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
		result = prime * result + Arrays.hashCode(logo);
		result = prime * result
				+ Objects.hash(address, cnpj, contactTravelAgency, createdOn, id, isActive, modifiedOn, name);
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
				&& Objects.equals(createdOn, other.createdOn) && Objects.equals(id, other.id)
				&& isActive == other.isActive && Arrays.equals(logo, other.logo)
				&& Objects.equals(modifiedOn, other.modifiedOn) && Objects.equals(name, other.name);
	}
	
}
