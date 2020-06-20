package com.example.vouviajarapirest.models;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAVEL_AGENCY", schema = "VOU_VIAJAR")
public class TravelAgency implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_USER")
	private Long id;
	
	@Column(name = "CODE_CADASTUR")
	private String codeCadastur;
		
	@Column(name = "IS_PHYSICAL_AGENCY")
	private String isPhysicalAgency;
	
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

	public String getCodeCadastur() {
		return codeCadastur;
	}

	public void setCodeCadastur(String codeCadastur) {
		this.codeCadastur = codeCadastur;
	}

	public String getIsPhysicalAgency() {
		return isPhysicalAgency;
	}

	public void setIsPhysicalAgency(String isPhysicalAgency) {
		this.isPhysicalAgency = isPhysicalAgency;
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
		return Objects.hash(codeCadastur, createdOn, id, isActive, isPhysicalAgency, modifiedOn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TravelAgency other = (TravelAgency) obj;
		return Objects.equals(codeCadastur, other.codeCadastur) && Objects.equals(createdOn, other.createdOn)
				&& Objects.equals(id, other.id) && isActive == other.isActive
				&& Objects.equals(isPhysicalAgency, other.isPhysicalAgency)
				&& Objects.equals(modifiedOn, other.modifiedOn);
	}
	
}