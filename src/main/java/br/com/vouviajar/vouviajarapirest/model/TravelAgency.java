package br.com.vouviajar.vouviajarapirest.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TRAVEL_AGENCY", schema = "vouviajar")
public class TravelAgency extends Company{

	public TravelAgency(){
		
	}
	
	public TravelAgency(String codeCadastur, boolean isPhysicalAgency) {
		this.codeCadastur = codeCadastur;
		this.isPhysicalAgency = isPhysicalAgency;
	}
		
	private static final long serialVersionUID = 1L;
	

	@Column(name = "CODE_CADASTUR")
	private String codeCadastur;
		
	@Column(name = "IS_PHYSICAL_AGENCY")
	private boolean isPhysicalAgency;
	
	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	
	@Column(name = "CREATED_ON")
	private OffsetDateTime createdOn;
	
	@Column(name = "MODIFIED_ON")
	private OffsetDateTime modifiedOn;

	public String getCodeCadastur() {
		return codeCadastur;
	}

	public void setCodeCadastur(String codeCadastur) {
		this.codeCadastur = codeCadastur;
	}

	public boolean getIsPhysicalAgency() {
		return isPhysicalAgency;
	}

	public void setIsPhysicalAgency(boolean isPhysicalAgency) {
		this.isPhysicalAgency = isPhysicalAgency;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
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
		return Objects.hash(codeCadastur, createdOn, isActive, isPhysicalAgency,
				modifiedOn);
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
				&& isActive == other.isActive
				&& Objects.equals(isPhysicalAgency, other.isPhysicalAgency)
				&& Objects.equals(modifiedOn, other.modifiedOn);
	}
	
}
