package br.com.vouviajar.company.dto;

import br.com.vouviajar.company.model.TravelAgency;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelAgencyDTO{
   
	public TravelAgencyDTO(String codeCadastur, boolean physicalAgency) {
		this.codeCadastur = codeCadastur;
		this.physicalAgency = physicalAgency;
	}

	private String codeCadastur;
    
    private boolean physicalAgency;
        
	public String getCodeCadastur() {
		return codeCadastur;
	}

	public void setCodeCadastur(String codeCadastur) {
		this.codeCadastur = codeCadastur;
	}

	public boolean isPhysicalAgency() {
		return physicalAgency;
	}

	public void setPhysicalAgency(boolean physicalAgency) {
		this.physicalAgency = physicalAgency;
	}

	public static TravelAgencyDTO toDTO(TravelAgency travelAgency){
        return new TravelAgencyDTO(travelAgency.getCodeCadastur(), travelAgency.isPhysicalAgency());
    }
	
	public static TravelAgencyDTO toDTO(Optional<TravelAgency> travelAgencyOptional){
		TravelAgency travelAgency = travelAgencyOptional.get();
        return new TravelAgencyDTO(travelAgency.getCodeCadastur(), travelAgency.isPhysicalAgency());
    }

	public static List<TravelAgencyDTO> toDTO(List<TravelAgency> travelAgencys){
		
		List<TravelAgencyDTO> travelAgencysDTO = new ArrayList<TravelAgencyDTO>();
		
		for(TravelAgency travelAgency : travelAgencys) {
			travelAgencysDTO.add(toDTO(travelAgency));
		}
        return travelAgencysDTO;
    }

	public TravelAgency toTravelAgency(){
        return new TravelAgency( getCodeCadastur(), isPhysicalAgency());
    }
	
}