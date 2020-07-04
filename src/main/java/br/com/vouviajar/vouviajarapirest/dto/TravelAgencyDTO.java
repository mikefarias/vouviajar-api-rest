package br.com.vouviajar.vouviajarapirest.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.vouviajar.vouviajarapirest.model.TravelAgency;

public class TravelAgencyDTO{
   
	public TravelAgencyDTO(String codeCadastur, boolean isPhysicalAgency) {
		this.codeCadastur = codeCadastur;
		this.isPhysicalAgency = isPhysicalAgency;
	}

	private String codeCadastur;
    
    private boolean isPhysicalAgency;
        
	public String getCodeCadastur() {
		return codeCadastur;
	}

	public void setCodeCadastur(String codeCadastur) {
		this.codeCadastur = codeCadastur;
	}

	public boolean getIsPhysicalAgency() {
		return isPhysicalAgency;
	}

	public void setIsPhysicalAgency(boolean isPhysicalAgency) {
		this.isPhysicalAgency = isPhysicalAgency;
	}

	public static TravelAgencyDTO toDTO(TravelAgency travelAgency){
        return new TravelAgencyDTO(travelAgency.getCodeCadastur(), travelAgency.getIsPhysicalAgency());
    }
	
	public static TravelAgencyDTO toDTO(Optional<TravelAgency> travelAgencyOptional){
		TravelAgency travelAgency = travelAgencyOptional.get();
        return new TravelAgencyDTO(travelAgency.getCodeCadastur(), travelAgency.getIsPhysicalAgency());
    }

	public static List<TravelAgencyDTO> toDTO(List<TravelAgency> travelAgencys){
		
		List<TravelAgencyDTO> travelAgencysDTO = new ArrayList<TravelAgencyDTO>();
		
		for(TravelAgency travelAgency : travelAgencys) {
			travelAgencysDTO.add(toDTO(travelAgency));
		}
        return travelAgencysDTO;
    }

	public TravelAgency toTravelAgency(){
        return new TravelAgency( getCodeCadastur(), getIsPhysicalAgency());
    }
	
}