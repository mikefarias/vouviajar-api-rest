package br.com.vouviajar.vouviajarapirest.models;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRAVEL_PACKAGE", schema="VOU_VIAJAR")
public class TravelPackage implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_TRAVEL_PACKAGE")
	private Long idTravelPackage;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="INVESTIMENT")
	private double investiment;
	
	@Column(name="ID_TRAVEL")
	private Travel idTravel;
	
	@Column(name = "REGISTRATION_USER")
	private User registrationUser;

	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	@Column(name = "CREATED_ON")
	private OffsetDateTime createdOn;
	
	@Column(name = "MODIFIED_ON")
	private OffsetDateTime modifiedOn;

	public Long getIdTravelPackage() {
		return idTravelPackage;
	}

	public void setIdTravelPackage(Long idTravelPackage) {
		this.idTravelPackage = idTravelPackage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getInvestiment() {
		return investiment;
	}

	public void setInvestiment(double investiment) {
		this.investiment = investiment;
	}

	public Travel getIdTravel() {
		return idTravel;
	}

	public void setIdTravel(Travel idTravel) {
		this.idTravel = idTravel;
	}

	public User getRegistrationUser() {
		return registrationUser;
	}

	public void setRegistrationUser(User registrationUser) {
		this.registrationUser = registrationUser;
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
		return Objects.hash(createdOn, idTravel, idTravelPackage, investiment, isActive, modifiedOn, name,
				registrationUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TravelPackage other = (TravelPackage) obj;
		return Objects.equals(createdOn, other.createdOn) && Objects.equals(idTravel, other.idTravel)
				&& Objects.equals(idTravelPackage, other.idTravelPackage)
				&& Double.doubleToLongBits(investiment) == Double.doubleToLongBits(other.investiment)
				&& isActive == other.isActive && Objects.equals(modifiedOn, other.modifiedOn)
				&& Objects.equals(name, other.name) && Objects.equals(registrationUser, other.registrationUser);
	}	

}
