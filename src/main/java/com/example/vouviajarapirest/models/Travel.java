package com.example.vouviajarapirest.models;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAVEL", schema = "VOU_VIAJAR")
public class Travel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_USER")
	private Long idTravel; 
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="DETAILS")
	private String details;
	
	@Column(name = "START_TIME")
	private OffsetDateTime start_time;
	
	@Column(name = "END_TIME")
	private OffsetDateTime end_time;
	
	@Column(name = "ORIGIN")
	private String origin;
	
	@Column(name = "DESTINY")
	private String destiny;	
	
	@Column(name="VACANCIES")
	private int vacancies;

	@Column(name="VACANCIES_AVAILABLE")
	private int vacancies_available;
				
	@Column(name="ID_TRAVEL_TYPE")
	private TravelType idTravelType; 
	
	@Column(name="ID_TRAVEL_STATUS")
	private TravelStatus idTravelStatus;
	
	@Column(name="ID_TRAVEL_PACKAGE")
	private TravelPackage idTravelPackage;

	@Column(name = "REGISTRATION_USER")
	private User registrationUser;

	@Column(name = "ID_TRAVEL_AGENCY")
	private TravelAgency idTravelAgency;

	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	@Column(name = "CREATED_ON")
	private OffsetDateTime createdOn;
	
	@Column(name = "MODIFIED_ON")
	private OffsetDateTime modifiedOn;

	public Long getIdTravel() {
		return idTravel;
	}

	public void setIdTravel(Long idTravel) {
		this.idTravel = idTravel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public OffsetDateTime getStart_time() {
		return start_time;
	}

	public void setStart_time(OffsetDateTime start_time) {
		this.start_time = start_time;
	}

	public OffsetDateTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(OffsetDateTime end_time) {
		this.end_time = end_time;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public int getVacancies() {
		return vacancies;
	}

	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}

	public int getVacancies_available() {
		return vacancies_available;
	}

	public void setVacancies_available(int vacancies_available) {
		this.vacancies_available = vacancies_available;
	}

	public TravelType getIdTravelType() {
		return idTravelType;
	}

	public void setIdTravelType(TravelType idTravelType) {
		this.idTravelType = idTravelType;
	}

	public TravelStatus getIdTravelStatus() {
		return idTravelStatus;
	}

	public void setIdTravelStatus(TravelStatus idTravelStatus) {
		this.idTravelStatus = idTravelStatus;
	}

	public TravelPackage getIdTravelPackage() {
		return idTravelPackage;
	}

	public void setIdTravelPackage(TravelPackage idTravelPackage) {
		this.idTravelPackage = idTravelPackage;
	}

	public User getRegistrationUser() {
		return registrationUser;
	}

	public void setRegistrationUser(User registrationUser) {
		this.registrationUser = registrationUser;
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
		return Objects.hash(createdOn, destiny, details, end_time, idTravelAgency, idTravelPackage, idTravelStatus,
				idTravelType, idTravel, isActive, modifiedOn, origin, registrationUser, start_time, title, vacancies,
				vacancies_available);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Travel other = (Travel) obj;
		return Objects.equals(createdOn, other.createdOn) && Objects.equals(destiny, other.destiny)
				&& Objects.equals(details, other.details) && Objects.equals(end_time, other.end_time)
				&& Objects.equals(idTravelAgency, other.idTravelAgency)
				&& Objects.equals(idTravelPackage, other.idTravelPackage)
				&& Objects.equals(idTravelStatus, other.idTravelStatus)
				&& Objects.equals(idTravelType, other.idTravelType) && Objects.equals(idTravel, other.idTravel)
				&& isActive == other.isActive && Objects.equals(modifiedOn, other.modifiedOn)
				&& Objects.equals(origin, other.origin) && Objects.equals(registrationUser, other.registrationUser)
				&& Objects.equals(start_time, other.start_time) && Objects.equals(title, other.title)
				&& vacancies == other.vacancies && vacancies_available == other.vacancies_available;
	}
		

}
