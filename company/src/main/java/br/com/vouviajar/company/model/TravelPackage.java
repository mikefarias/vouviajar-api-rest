package br.com.vouviajar.company.model;

import br.com.vouviajar.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name="travel_package", schema="company")
public class TravelPackage implements Serializable{
	
	public TravelPackage() {
		
	}
	
	public TravelPackage(String name, double investiment) {
		this.name = name;
		this.investiment = investiment;
	}
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_travel_package")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="investiment")
	private double investiment;
	
	@ManyToOne
	@JoinColumn(name="id_travel")
	private Travel idTravel;
	
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
		return Objects.hash(createdOn, idTravel, id, investiment, active, modifiedOn, name,
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
				&& Objects.equals(id, other.id)
				&& Double.doubleToLongBits(investiment) == Double.doubleToLongBits(other.investiment)
				&& active == other.active && Objects.equals(modifiedOn, other.modifiedOn)
				&& Objects.equals(name, other.name) && Objects.equals(registrationUser, other.registrationUser);
	}	
}
