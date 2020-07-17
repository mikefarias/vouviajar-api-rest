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
@Table(name="travel", schema="company")
public class Travel implements Serializable{
	
	public Travel() {
		
	}
	
	public Travel(String title, String details, OffsetDateTime startTime, OffsetDateTime endTime, String origin,
			String destiny, int vacancies, int vacanciesAvailable, TravelType idTravelType,
			TravelStatus idTravelStatus, TravelPackage idTravelPackage) {
		this.title = title;
		this.details = details;
		this.startTime = startTime;
		this.endTime = endTime;
		this.origin = origin;
		this.destiny = destiny;
		this.vacancies = vacancies;
		this.vacanciesAvailable = vacanciesAvailable;
		this.idTravelType = idTravelType;
		this.idTravelStatus = idTravelStatus;
		this.idTravelPackage = idTravelPackage;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_travel")
	private Long id; 
	
	@Column(name="title")
	private String title;
	
	@Column(name="details")
	private String details;
	
	@Column(name="start_time")
	private OffsetDateTime startTime;
	
	@Column(name="end_time")
	private OffsetDateTime endTime;
	
	@Column(name="origin")
	private String origin;
	
	@Column(name="destiny")
	private String destiny;	
	
	@Column(name="vacancies")
	private int vacancies;

	@Column(name="vacancies_available")
	private int vacanciesAvailable;
				
	@OneToOne
	@JoinColumn(name="id_travel_type")
	private TravelType idTravelType; 
	
	@OneToOne
	@JoinColumn(name="id_travel_status")
	private TravelStatus idTravelStatus;
	
	@OneToOne
	@JoinColumn(name="id_travel_package")
	private TravelPackage idTravelPackage;

	@OneToOne
	@JoinColumn(name="registration_user")
	private User registrationUser;

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

	public OffsetDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(OffsetDateTime startTime) {
		this.startTime = startTime;
	}

	public OffsetDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(OffsetDateTime endTime) {
		this.endTime = endTime;
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

	public int getVacanciesAvailable() {
		return vacanciesAvailable;
	}

	public void setVacanciesAvailable(int vacanciesAvailable) {
		this.vacanciesAvailable = vacanciesAvailable;
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
		return Objects.hash(createdOn, destiny, details, endTime, idTravelAgency, idTravelPackage, idTravelStatus,
				idTravelType, id, active, modifiedOn, origin, registrationUser, startTime, title, vacancies,
				vacanciesAvailable);
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
				&& Objects.equals(details, other.details) && Objects.equals(endTime, other.endTime)
				&& Objects.equals(idTravelAgency, other.idTravelAgency)
				&& Objects.equals(idTravelPackage, other.idTravelPackage)
				&& Objects.equals(idTravelStatus, other.idTravelStatus)
				&& Objects.equals(idTravelType, other.idTravelType) && Objects.equals(id, other.id)
				&& active == other.active && Objects.equals(modifiedOn, other.modifiedOn)
				&& Objects.equals(origin, other.origin) && Objects.equals(registrationUser, other.registrationUser)
				&& Objects.equals(startTime, other.startTime) && Objects.equals(title, other.title)
				&& vacancies == other.vacancies && vacanciesAvailable == other.vacanciesAvailable;
	}
		

}
