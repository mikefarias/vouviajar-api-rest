package br.com.vouviajar.vouviajarapirest.model;

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
@Table(name="travel_package_contract", schema="vouviajar")
public class TravelPackageContract implements Serializable{

	private final static long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_travel_package_contract")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="id_travel_contract")
	private TravelContract idTravelContract;

	@OneToOne
	@JoinColumn(name="id_travel_package")
	private TravelPackage idTravelPackage;
	
	@OneToOne
	@JoinColumn(name="id_travel_agency")
	private TravelAgency idTravelAgency;

	@Column(name="active")
	private boolean active;
	
	@Column(name="created_on")
	private OffsetDateTime createdOn;
	
	@Column(name="modified_on")
	private OffsetDateTime modifiedOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		return Objects.hash(createdOn, idTravelAgency, idTravelContract, idTravelPackage, id,
				active, modifiedOn);
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
				&& Objects.equals(id, other.id) && active == other.active
				&& Objects.equals(modifiedOn, other.modifiedOn);
	}

}
