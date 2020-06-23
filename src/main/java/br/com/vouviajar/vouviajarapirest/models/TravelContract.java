package br.com.vouviajar.vouviajarapirest.models;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TRAVEL_CONTRACT", schema="vouviajar")
public class TravelContract implements Serializable{

	private final static long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_TRAVEL_CONTRACT")
	private Long idTravelContract;
	
	@Column(name="TERMS")
	private String terms;
	
	@OneToOne
	@JoinColumn(name = "ID_TRAVEL_AGENCY")
	private TravelAgency idTravelAgency;

	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	
	@Column(name = "CREATED_ON")
	private OffsetDateTime createdOn;
	
	@Column(name = "MODIFIED_ON")
	private OffsetDateTime modifiedOn;

	public Long getIdTravelContract() {
		return idTravelContract;
	}

	public void setIdTravelContract(Long idTravelContract) {
		this.idTravelContract = idTravelContract;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public TravelAgency getIdTravelAgency() {
		return idTravelAgency;
	}

	public void setIdTravelAgency(TravelAgency idTravelAgency) {
		this.idTravelAgency = idTravelAgency;
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
		result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + ((idTravelAgency == null) ? 0 : idTravelAgency.hashCode());
		result = prime * result + ((idTravelContract == null) ? 0 : idTravelContract.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((modifiedOn == null) ? 0 : modifiedOn.hashCode());
		result = prime * result + ((terms == null) ? 0 : terms.hashCode());
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
		TravelContract other = (TravelContract) obj;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (idTravelAgency == null) {
			if (other.idTravelAgency != null)
				return false;
		} else if (!idTravelAgency.equals(other.idTravelAgency))
			return false;
		if (idTravelContract == null) {
			if (other.idTravelContract != null)
				return false;
		} else if (!idTravelContract.equals(other.idTravelContract))
			return false;
		if (isActive != other.isActive)
			return false;
		if (modifiedOn == null) {
			if (other.modifiedOn != null)
				return false;
		} else if (!modifiedOn.equals(other.modifiedOn))
			return false;
		if (terms == null) {
			if (other.terms != null)
				return false;
		} else if (!terms.equals(other.terms))
			return false;
		return true;
	}
	
}
