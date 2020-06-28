package br.com.vouviajar.vouviajarapirest.models;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRAVEL_AGENCY", schema = "vouviajar")
public class TravelAgency implements Serializable{

	public TravelAgency(){
		
	}
	
	public TravelAgency(String codeCadastur, boolean isPhysicalAgency) {
		this.codeCadastur = codeCadastur;
		this.isPhysicalAgency = isPhysicalAgency;
	}
		
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRAVEL_AGENCY")
	private Long idTravelAgency;
	
	@Column(name = "CODE_CADASTUR")
	private String codeCadastur;
		
	@Column(name = "IS_PHYSICAL_AGENCY")
	private boolean isPhysicalAgency;
	
	@OneToOne
	@JoinColumn(name="ID_TRAVEL_AGENCY_CONTACT")
	private TravelAgencyContact idTravelAgencyContact;
	
	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	
	@Column(name = "CREATED_ON")
	private OffsetDateTime createdOn;
	
	@Column(name = "MODIFIED_ON")
	private OffsetDateTime modifiedOn;

	public Long getIdTravelAgency() {
		return idTravelAgency;
	}

	public void setIdTravelAgency(Long idTravelAgency) {
		this.idTravelAgency = idTravelAgency;
	}

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

	public TravelAgencyContact getTravelAgencyContact() {
		return idTravelAgencyContact;
	}

	public void setTravelAgencyContact(TravelAgencyContact idTravelAgencyContact) {
		this.idTravelAgencyContact = idTravelAgencyContact;
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
		return Objects.hash(codeCadastur, createdOn, idTravelAgency, idTravelAgencyContact, isActive, isPhysicalAgency,
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
				&& Objects.equals(idTravelAgency, other.idTravelAgency)
				&& Objects.equals(idTravelAgencyContact, other.idTravelAgencyContact) && isActive == other.isActive
				&& Objects.equals(isPhysicalAgency, other.isPhysicalAgency)
				&& Objects.equals(modifiedOn, other.modifiedOn);
	}
	
}
