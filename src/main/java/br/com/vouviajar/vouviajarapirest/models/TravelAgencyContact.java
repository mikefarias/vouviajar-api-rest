package br.com.vouviajar.vouviajarapirest.models;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT_TRAVEL_AGENCY", schema = "VOU_VIAJAR")
public class TravelAgencyContact implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_USER")
	private Long id;
	
	@Column(name = "EMAIL")
	private String email; 
	
	@Column(name = "PHONE_NUMBER")
	private String phone_numer;

	
	@Column(name = "WHATSAPP" )
	private String whatsapp;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_numer() {
		return phone_numer;
	}

	public void setPhone_numer(String phone_numer) {
		this.phone_numer = phone_numer;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
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
		return Objects.hash(createdOn, email, id, isActive, modifiedOn, phone_numer, whatsapp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TravelAgencyContact other = (TravelAgencyContact) obj;
		return Objects.equals(createdOn, other.createdOn) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && isActive == other.isActive
				&& Objects.equals(modifiedOn, other.modifiedOn) && Objects.equals(phone_numer, other.phone_numer)
				&& Objects.equals(whatsapp, other.whatsapp);
	}
	
}
