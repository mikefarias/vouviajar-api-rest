package br.com.vouviajar.vouviajarapirest.model;

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
@Table(name="TRAVEL_PACKAGE_CONTRACT", schema="vouviajar")
public class TravelPackageContract implements Serializable{

	private final static long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_TRAVEL_PACKAGE_CONTRACT")
	private Long idTravelPackageContract;
	
	@OneToOne
	@JoinColumn(name = "ID_TRAVEL_CONTRACT")
	private TravelContract idTravelContract;

	@OneToOne
	@JoinColumn(name = "ID_TRAVEL_PACKAGE")
	private TravelPackage idTravelPackage;
	
	@OneToOne
	@JoinColumn(name = "ID_TRAVEL_AGENCY")
	private TravelAgency idTravelAgency;

	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	
	@Column(name = "CREATED_ON")
	private OffsetDateTime createdOn;
	
	@Column(name = "MODIFIED_ON")
	private OffsetDateTime modifiedOn;

	public Long getIdTravelPackageContract() {
		return idTravelPackageContract;
	}

	public void setIdTravelPackageContract(Long idTravelPackageContract) {
		this.idTravelPackageContract = idTravelPackageContract;
	}

	public TravelContract getIdTravelContract() {
		return idTravelContract;
	}

	public void setIdTravelContract(TravelContract idTravelContract) {
		this.idTravelContract = idTravelContract;
	}

	public TravelPackage getIdTravelPackage() {
		return idTravelPackage;
	}

	public void setIdTravelPackage(TravelPackage idTravelPackage) {
		this.idTravelPackage = idTravelPackage;
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
		return Objects.hash(createdOn, idTravelAgency, idTravelContract, idTravelPackage, idTravelPackageContract,
				isActive, modifiedOn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TravelPackageContract other = (TravelPackageContract) obj;
		return Objects.equals(createdOn, other.createdOn) && Objects.equals(idTravelAgency, other.idTravelAgency)
				&& Objects.equals(idTravelContract, other.idTravelContract)
				&& Objects.equals(idTravelPackage, other.idTravelPackage)
				&& Objects.equals(idTravelPackageContract, other.idTravelPackageContract) && isActive == other.isActive
				&& Objects.equals(modifiedOn, other.modifiedOn);
	}

}
