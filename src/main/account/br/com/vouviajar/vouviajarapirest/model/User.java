package br.com.vouviajar.vouviajarapirest.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user", schema="vouviajar")
public class User {
	
	public User() {
	}
	
	public User(String email) {
		this.email = email;
	}

	public User(String email, String password, boolean active, boolean enabled, boolean staff,
			OffsetDateTime dateJoined, OffsetDateTime createdOn, OffsetDateTime modifiedOn) {
		this.email = email;
		this.password = password;
		this.active = active;
		this.enabled = enabled;
		this.staff = staff;
		this.dateJoined = dateJoined;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user", nullable = false)
	private Long id;
	
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="active", nullable = false)
	private boolean active;
	
	@Column(name="enabled", nullable = false)
	private boolean enabled;
	
	@Column(name="staff", nullable = false)
	private boolean staff;
	
	@Column(name="date_joined")
	private OffsetDateTime dateJoined;
	
	@Column(name="created_on", nullable = false)
	private OffsetDateTime createdOn;
	
	@Column(name="modified_on", nullable = false)
	private OffsetDateTime modifiedOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnable(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isStaff() {
		return staff;
	}

	public void setStaff(boolean staff) {
		this.staff = staff;
	}

	public OffsetDateTime getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(OffsetDateTime dateJoined) {
		this.dateJoined = dateJoined;
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
	
	public boolean isEmpty() {
		boolean isEmpty = email == "" && password == "" ? true : false;
		return isEmpty;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(createdOn, dateJoined, email, id, active, enabled, staff, modifiedOn, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(createdOn, other.createdOn) && Objects.equals(dateJoined, other.dateJoined)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id) && active == other.active
				&& enabled == other.enabled && staff == other.staff
				&& Objects.equals(modifiedOn, other.modifiedOn)
				&& Objects.equals(password, other.password);
	}
}