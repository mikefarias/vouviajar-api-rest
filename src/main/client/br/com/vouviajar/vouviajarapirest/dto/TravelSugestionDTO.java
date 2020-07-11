package br.com.vouviajar.vouviajarapirest.dto;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.vouviajar.vouviajarapirest.model.TravelSugestion;

public class TravelSugestionDTO{
   
	public TravelSugestionDTO() {
	}

	public TravelSugestionDTO(String title, String details, OffsetDateTime startTime, OffsetDateTime endTime, String origin,
			String destiny, int vacancies ) {
		this.title = title;
		this.details = details;
		this.startTime = startTime;
		this.endTime = endTime;
		this.origin = origin;
		this.destiny = destiny;
		this.vacancies = vacancies;
	}

	private String title;
	
	private String details;
	
	private OffsetDateTime startTime;
	
	private OffsetDateTime endTime;
	
	private String origin;
	
	private String destiny;	
	
	private int vacancies;
	
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

	public static TravelSugestionDTO toDTO(TravelSugestion travelSugestion){
        return new TravelSugestionDTO(travelSugestion.getTitle(), travelSugestion.getDetails(), travelSugestion.getStartTime(), travelSugestion.getEndTime(), 
        		travelSugestion.getOrigin(), travelSugestion.getDestiny(), travelSugestion.getVacancies());
    }
	
	public static TravelSugestionDTO toDTO(Optional<TravelSugestion> travelSugestionOptional){
		TravelSugestion travelSugestion = travelSugestionOptional.get();
        return new TravelSugestionDTO(travelSugestion.getTitle(), travelSugestion.getDetails(), travelSugestion.getStartTime(), travelSugestion.getEndTime(), 
        		travelSugestion.getOrigin(), travelSugestion.getDestiny(), travelSugestion.getVacancies());
    }

	public static List<TravelSugestionDTO> toDTO(List<TravelSugestion> travelSugestions){
		
		List<TravelSugestionDTO> travelSugestionAgencysDTO = new ArrayList<TravelSugestionDTO>();
		
		for(TravelSugestion travelSugestion : travelSugestions) {
			travelSugestionAgencysDTO.add(toDTO(travelSugestion));
		}
        return travelSugestionAgencysDTO;
    }

	public TravelSugestion toTravelSugestion(){
        return new TravelSugestion(getTitle(), getDetails(), getStartTime(), getEndTime(), 
        		getOrigin(), getDestiny(), getVacancies());
    }
	
}