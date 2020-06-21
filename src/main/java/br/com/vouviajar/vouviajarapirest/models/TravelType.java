package br.com.vouviajar.vouviajarapirest.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRAVEL_TYPE", schema="VOU_VIAJAR")
public class TravelType implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_TRAVEL_TYPE")
	private Long idTravelType;
	
	@Column(name="TRAVEL_TYPE")
	private String travelType;

	@Column(name="DESCRIPTION")
	private String description;

	public Long getIdTravelType() {
		return idTravelType;
	}

	public void setIdTravelType(Long idTravelType) {
		this.idTravelType = idTravelType;
	}

	public String getTravelType() {
		return travelType;
	}

	public void setTravelType(String travelType) {
		this.travelType = travelType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, idTravelType, travelType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TravelType other = (TravelType) obj;
		return Objects.equals(description, other.description) && Objects.equals(idTravelType, other.idTravelType)
				&& Objects.equals(travelType, other.travelType);
	}
		
}
