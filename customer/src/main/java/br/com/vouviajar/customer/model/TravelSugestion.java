package br.com.vouviajar.customer.model;

import br.com.vouviajar.model.Person;
import br.com.vouviajar.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name="travel_sugestion", schema="customer==")
public class TravelSugestion implements Serializable{

	public TravelSugestion() {
		
	}
	
	public TravelSugestion(String title, String details, OffsetDateTime startTime, OffsetDateTime endTime, String origin,
			String destiny, int vacancies ) {
		this.title = title;
		this.details = details;
		this.startTime = startTime;
		this.endTime = endTime;
		this.origin = origin;
		this.destiny = destiny;
		this.vacancies = vacancies;
	}
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_travel_sugestion")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="id_person")
	private Person idPerson;
		
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
	
	@OneToOne
	@JoinColumn(name="registration_user")
	private User registrationUser;

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

	public User getRegistrationUser() {
		return registrationUser;
	}

	public void setRegistrationUser(User registrationUser) {
		this.registrationUser = registrationUser;
	}

	public boolean active() {
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
		return Objects.hash(createdOn, destiny, details, endTime, idPerson, id, active, modifiedOn,
				origin, registrationUser, startTime, title, vacancies);
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
				&& Objects.equals(details, other.details) && Objects.equals(endTime, other.endTime)
				&& Objects.equals(idPerson, other.idPerson)
				&& Objects.equals(id, other.id) && active == other.active
				&& Objects.equals(modifiedOn, other.modifiedOn) && Objects.equals(origin, other.origin)
				&& Objects.equals(registrationUser, other.registrationUser)
				&& Objects.equals(startTime, other.startTime) && Objects.equals(title, other.title)
				&& vacancies == other.vacancies;
	}
}
