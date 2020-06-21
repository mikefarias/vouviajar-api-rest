package com.example.vouviajarapirest.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION_STATUS", schema="VOU_VIAJAR")
public class ReservationStatus implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_RESERVATION_STATUS")
	private Long idReservationStatus;
	
	@Column(name="RESERVATION_STATUS")
	private String reservationStatus;
	
	@Column(name="DESCRIPTION")
	private String description;

	public Long getIdReservationStatus() {
		return idReservationStatus;
	}

	public void setIdReservationStatus(Long idReservationStatus) {
		this.idReservationStatus = idReservationStatus;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, idReservationStatus, reservationStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationStatus other = (ReservationStatus) obj;
		return Objects.equals(description, other.description)
				&& Objects.equals(idReservationStatus, other.idReservationStatus)
				&& Objects.equals(reservationStatus, other.reservationStatus);
	}

}
