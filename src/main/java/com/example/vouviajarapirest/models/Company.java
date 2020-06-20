package com.example.vouviajarapirest.models;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY", schema = "VOU_VIAJAR")
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_COMPANY")
	private Long idCompany;
	
	@Column(name = "NAME")
	private String name; 
	
	@Column(name = "CNPJ")
	private String cnpj;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "LOGO", columnDefinition="BLOB")
	private byte[] logo;
	
	@Column(name = "ADDRESS")
	private Address address;

	@Column(name = "TRAVEL_AGENCY")
	private TravelAgency travelAgency;

	@Column(name = "CONTACT_TRAVEL_AGENCY")
	private TravelAgencyContact contactTravelAgency;
	
	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	
	@Column(name = "CREATED_ON")
	private OffsetDateTime createdOn;
	
	@Column(name = "CREATED_ON")
	private OffsetDateTime modifiedOn;

}
