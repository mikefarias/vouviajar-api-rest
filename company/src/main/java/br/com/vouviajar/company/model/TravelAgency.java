package br.com.vouviajar.company.model;

import br.com.vouviajar.model.Company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name="travel_agency", schema="company")
public class TravelAgency extends Company {

	public TravelAgency(){
		
	}
	
	public TravelAgency(String codeCadastur, boolean physicalAgency) {
		this.codeCadastur = codeCadastur;
		this.physicalAgency = physicalAgency;
	}
		
	private static final long serialVersionUID = 1L;
	

	@Column(name="code_cadastur")
	private String codeCadastur;
		
	@Column(name="physical_agency")
	private boolean physicalAgency;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="created_on")
	private OffsetDateTime createdOn;
	
	@Column(name="modified_on")
	private OffsetDateTime modifiedOn;

	public String getCodeCadastur() {
		return codeCadastur;
	}

	public void setCodeCadastur(String codeCadastur) {
		this.codeCadastur = codeCadastur;
	}

	public boolean isPhysicalAgency() {
		return physicalAgency;
	}

	public void setPhysicalAgency(boolean physicalAgency) {
		this.physicalAgency = physicalAgency;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
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
		return Objects.hash(codeCadastur, createdOn, active, physicalAgency,
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
				&& active == other.active
				&& Objects.equals(physicalAgency, other.physicalAgency)
				&& Objects.equals(modifiedOn, other.modifiedOn);
	}
	
}
