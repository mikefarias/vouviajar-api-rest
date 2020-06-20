package com.example.vouviajarapirest.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRAVEL_STATUS", schema="VOU_VIAJAR")
public class TravelStatus implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_TRAVEL_STATUS")
	private Long idTravelStatus;
	
	@Column(name="TRAVEL_STATUS")
	private String travelStatus;
	
	@Column(name="DESCRIPTION")
	private String description;

	public Long getIdTravelStatus() {
		return idTravelStatus;
	}

	public void setIdTravelStatus(Long idTravelStatus) {
		this.idTravelStatus = idTravelStatus;
	}

	public String getTravelStatus() {
		return travelStatus;
	}

	public void setTravelStatus(String travelStatus) {
		this.travelStatus = travelStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, idTravelStatus, travelStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TravelStatus other = (TravelStatus) obj;
		return Objects.equals(description, other.description) && Objects.equals(idTravelStatus, other.idTravelStatus)
				&& Objects.equals(travelStatus, other.travelStatus);
	}	

}
