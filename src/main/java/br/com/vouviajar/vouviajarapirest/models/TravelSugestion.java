package br.com.vouviajar.vouviajarapirest.models;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TravelSugestion", schema="VOU_VIAJAR")
public class TravelSugestion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_TRAVEL_SUGESTION")
	private Long idTravelSugestion;
	
	@Column(name="ID_PERSON")
	private Person idPerson;
		
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
	
	@Column(name = "REGISTRATION_USER")
	private User registrationUser;

	@Column(name = "IS_ACTIVE")
	private boolean isActive;

	@Column(name = "CREATED_ON")
	private OffsetDateTime createdOn;
	
	@Column(name = "MODIFIED_ON")
	private OffsetDateTime modifiedOn;

	public Long getIdTravelSugestion() {
		return idTravelSugestion;
	}

	public void setIdTravelSugestion(Long idTravelSugestion) {
		this.idTravelSugestion = idTravelSugestion;
	}

	public Person getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Person idPerson) {
		this.idPerson = idPerson;
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
		return Objects.hash(createdOn, destiny, details, end_time, idPerson, idTravelSugestion, isActive, modifiedOn,
				origin, registrationUser, start_time, title, vacancies);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TravelSugestion other = (TravelSugestion) obj;
		return Objects.equals(createdOn, other.createdOn) && Objects.equals(destiny, other.destiny)
				&& Objects.equals(details, other.details) && Objects.equals(end_time, other.end_time)
				&& Objects.equals(idPerson, other.idPerson)
				&& Objects.equals(idTravelSugestion, other.idTravelSugestion) && isActive == other.isActive
				&& Objects.equals(modifiedOn, other.modifiedOn) && Objects.equals(origin, other.origin)
				&& Objects.equals(registrationUser, other.registrationUser)
				&& Objects.equals(start_time, other.start_time) && Objects.equals(title, other.title)
				&& vacancies == other.vacancies;
	}
	
}
