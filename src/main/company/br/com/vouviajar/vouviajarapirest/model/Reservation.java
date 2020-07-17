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
@Table(name="reservation", schema="company")
public class Reservation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reservation")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="id_travel_package_contract")
	private TravelPackageContract idTravelPackageContract;
	
	@OneToOne
	@JoinColumn(name="id_person")
	private Person idPerson;
	
	@OneToOne
	@JoinColumn(name="id_reservation_status")
	private ReservationStatus idReservationStatus;
	
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
		this.id= id;
	}

	public TravelPackageContract getIdTravelPackageContract() {
		return idTravelPackageContract;
	}

	public void setIdTravelPackageContract(TravelPackageContract idTravelPackageContract) {
		this.idTravelPackageContract = idTravelPackageContract;
	}

	public Person getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Person idPerson) {
		this.idPerson = idPerson;
	}

	public ReservationStatus getIdReservationStatus() {
		return idReservationStatus;
	}

	public void setIdReservationStatus(ReservationStatus idReservationStatus) {
		this.idReservationStatus = idReservationStatus;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
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
		return Objects.hash(createdOn, idPerson, id, idReservationStatus, idTravelPackageContract, active,
				modifiedOn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(createdOn, other.createdOn) && Objects.equals(idPerson, other.idPerson)
				&& Objects.equals(id, other.id)
				&& Objects.equals(idReservationStatus, other.idReservationStatus)
				&& Objects.equals(idTravelPackageContract, other.idTravelPackageContract) && active == other.active
				&& Objects.equals(modifiedOn, other.modifiedOn);
	}
}
