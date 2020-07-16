package br.com.vouviajar.vouviajarapirest.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person", schema="vouviajar")
public class Person implements Serializable {
	
	public Person() {
		
	}
	
	public Person(String firstName, String lastName, String phoneNumber, User user) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.user = user;
	}
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_person")
	private Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_user")
	private User user;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="active", nullable = false)
	private boolean active;
	
	@Column(name="created_on")
	private OffsetDateTime createdOn;
	
	@Column(name="modified_on")
	private OffsetDateTime modifiedOn;

	@OneToOne
	@JoinColumn(name="address")
	private Address address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, cpf, createdOn, id, user, active, modifiedOn, firstName, lastName, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(createdOn, other.createdOn) && Objects.equals(id, other.id)
				&& Objects.equals(user, other.user) && active == other.active
				&& Objects.equals(modifiedOn, other.modifiedOn)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName) 
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}
}
