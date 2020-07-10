package br.com.vouviajar.vouviajarapirest.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.vouviajar.vouviajarapirest.model.TravelContract;

public class TravelContractDTO{
   
	public TravelContractDTO() {
		
	}
	
	public TravelContractDTO(String terms) {
		this.terms = terms;
	}

	private String terms;
      
	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public static TravelContractDTO toDTO(TravelContract travelContract){
        return new TravelContractDTO(travelContract.getTerms());
    }
	
	public static TravelContractDTO toDTO(Optional<TravelContract> travelContractOptional){
		TravelContract travelContract = travelContractOptional.get();
        return new TravelContractDTO(travelContract.getTerms());
    }

	public static List<TravelContractDTO> toDTO(List<TravelContract> travelContracts){
		
		List<TravelContractDTO> travelContractsDTO = new ArrayList<TravelContractDTO>();
		
		for(TravelContract travelContract : travelContracts) {
			travelContractsDTO.add(toDTO(travelContract));
		}
        return travelContractsDTO;
    }

	public TravelContract toTravelContract(){
        return new TravelContract(getTerms());
    }
	
}