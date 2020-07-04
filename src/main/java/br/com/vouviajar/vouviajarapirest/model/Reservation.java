package br.com.vouviajar.vouviajarapirest.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="RESERVATION", schema="vouviajar")
public class Reservation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_RESERVATION")
	private Long idReservation;
	
	@OneToOne
	@JoinColumn(name="ID_TRAVEL_PACKAGE_CONTRACT")
	private TravelPackageContract idTravelPackageContract;
	
	@OneToOne
	@JoinColumn(name="ID_PERSON")
	private Person idPerson;
	
	@OneToOne
	@JoinColumn(name="ID_RESERVATION_STATUS")
	private ReservationStatus idReservationStatus;
	
	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	
	@Column(name = "CREATED_ON")
	private OffsetDateTime createdOn;
	
	@Column(name = "MODIFIED_ON")
	private OffsetDateTime modifiedOn;

	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
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
		return Objects.hash(createdOn, idPerson, idReservation, idReservationStatus, idTravelPackageContract, isActive,
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
				&& Objects.equals(idReservation, other.idReservation)
				&& Objects.equals(idReservationStatus, other.idReservationStatus)
				&& Objects.equals(idTravelPackageContract, other.idTravelPackageContract) && isActive == other.isActive
				&& Objects.equals(modifiedOn, other.modifiedOn);
	}

	

}
