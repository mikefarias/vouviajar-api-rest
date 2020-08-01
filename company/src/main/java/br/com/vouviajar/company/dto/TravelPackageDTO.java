package br.com.vouviajar.company.dto;

import br.com.vouviajar.company.model.TravelPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelPackageDTO{
   
	public TravelPackageDTO(String name, double investiment) {
		this.name = name;
		this.investiment = investiment;
	}

	private String name;
    
    private double investiment;
        
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getInvestiment() {
		return investiment;
	}

	public void setInvestiment(double investiment) {
		this.investiment = investiment;
	}

	public static TravelPackageDTO toDTO(TravelPackage travelPackage){
        return new TravelPackageDTO(travelPackage.getName(), travelPackage.getInvestiment());
    }
	
	public static TravelPackageDTO toDTO(Optional<TravelPackage> travelPackageOptional){
		TravelPackage travelPackage = travelPackageOptional.get();
        return new TravelPackageDTO(travelPackage.getName(), travelPackage.getInvestiment());
    }

	public static List<TravelPackageDTO> toDTO(List<TravelPackage> travelPackages){
		
		List<TravelPackageDTO> travelPackagesDTO = new ArrayList<TravelPackageDTO>();
		
		for(TravelPackage travelPackage : travelPackages) {
			travelPackagesDTO.add(toDTO(travelPackage));
		}
        return travelPackagesDTO;
    }

	public TravelPackage toTravelPackage(){
        return new TravelPackage( getName(), getInvestiment());
    }
	
}