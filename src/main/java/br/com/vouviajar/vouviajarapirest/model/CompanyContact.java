package br.com.vouviajar.vouviajarapirest.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT_TRAVEL_AGENCY", schema = "vouviajar")
public class CompanyContact implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_TRAVEL_AGENCY_CONTACT")
	private Long idTravelAgencyContact;
	
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
	
	@Column(name = "MODIFIED_ON")
	private OffsetDateTime modifiedOn;

	public Long getIdTravelAgencyContact() {
		return idTravelAgencyContact;
	}

	public void setIdTravelAgencyContact(Long idTravelAgencyContact) {
		this.idTravelAgencyContact = idTravelAgencyContact;
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
		return Objects.hash(createdOn, email, idTravelAgencyContact, isActive, modifiedOn, phone_numer, whatsapp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyContact other = (CompanyContact) obj;
		return Objects.equals(createdOn, other.createdOn) && Objects.equals(email, other.email)
				&& Objects.equals(idTravelAgencyContact, other.idTravelAgencyContact) && isActive == other.isActive
				&& Objects.equals(modifiedOn, other.modifiedOn) && Objects.equals(phone_numer, other.phone_numer)
				&& Objects.equals(whatsapp, other.whatsapp);
	}
	
}
