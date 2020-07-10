package br.com.vouviajar.vouviajarapirest.dto;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.vouviajar.vouviajarapirest.model.Travel;
import br.com.vouviajar.vouviajarapirest.model.TravelPackage;
import br.com.vouviajar.vouviajarapirest.model.TravelStatus;
import br.com.vouviajar.vouviajarapirest.model.TravelType;

public class TravelDTO{
   
	public TravelDTO() {
	}

	public TravelDTO(String title, String details, OffsetDateTime startTime, OffsetDateTime endTime, String origin,
			String destiny, int vacancies, int vacancies_available, TravelType idTravelType,
			TravelStatus idTravelStatus, TravelPackage idTravelPackage) {
		this.title = title;
		this.details = details;
		this.startTime = startTime;
		this.endTime = endTime;
		this.origin = origin;
		this.destiny = destiny;
		this.vacancies = vacancies;
		this.vacancies_available = vacancies_available;
		this.idTravelType = idTravelType;
		this.idTravelStatus = idTravelStatus;
		this.idTravelPackage = idTravelPackage;
	}



	private String title;
	
	private String details;
	
	private OffsetDateTime startTime;
	
	private OffsetDateTime endTime;
	
	private String origin;
	
	private String destiny;	
	
	private int vacancies;

	private int vacancies_available;
				
	private TravelType idTravelType; 
	
	private TravelStatus idTravelStatus;
	
	private TravelPackage idTravelPackage;
	
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

	public int getVacancies_available() {
		return vacancies_available;
	}

	public void setVacancies_available(int vacancies_available) {
		this.vacancies_available = vacancies_available;
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

	public static TravelDTO toDTO(Travel travel){
        return new TravelDTO(travel.getTitle(), travel.getDetails(), travel.getStartTime(), travel.getEndTime(), 
        		travel.getOrigin(), travel.getDestiny(), travel.getVacancies(), travel.getVacanciesAvailable(), 
        		travel.getIdTravelType(), travel.getIdTravelStatus(), travel.getIdTravelPackage());
    }
	
	public static TravelDTO toDTO(Optional<Travel> travelOptional){
		Travel travel = travelOptional.get();
        return new TravelDTO(travel.getTitle(), travel.getDetails(), travel.getStartTime(), travel.getEndTime(), 
        		travel.getOrigin(), travel.getDestiny(), travel.getVacancies(), travel.getVacanciesAvailable(), 
        		travel.getIdTravelType(), travel.getIdTravelStatus(), travel.getIdTravelPackage());
    }

	public static List<TravelDTO> toDTO(List<Travel> travels){
		
		List<TravelDTO> travelAgencysDTO = new ArrayList<TravelDTO>();
		
		for(Travel travel : travels) {
			travelAgencysDTO.add(toDTO(travel));
		}
        return travelAgencysDTO;
    }

	public Travel toTravel(){
        return new Travel(getTitle(), getDetails(), getStartTime(), getEndTime(), 
        		getOrigin(), getDestiny(), getVacancies(), getVacancies_available(), 
        		getIdTravelType(), getIdTravelStatus(), getIdTravelPackage());
    }
	
}