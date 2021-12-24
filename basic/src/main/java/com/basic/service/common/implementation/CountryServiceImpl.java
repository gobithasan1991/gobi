package com.basic.service.common.implementation;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.basic.extensible.CurrentStatus;
import com.basic.persitance.model.common.Country;
import com.basic.persitance.repository.common.CountryRepo;
import com.basic.service.common.CommonLogicService;
import com.basic.service.common.CountryService;
import com.basic.web.dto.common.IdName;
import com.basic.web.dto.common.RESTResponseMessage;

@Service
public class CountryServiceImpl implements CountryService{
	private CountryRepo countryRepo;
	private CommonLogicService commonLogicService;
	@Autowired
	public CountryServiceImpl(CountryRepo countryRepo,CommonLogicService commonLogicService) {
		super();
		this.countryRepo = countryRepo;
		this.commonLogicService = commonLogicService;
	} 
	@Override
	@Transactional
	public RESTResponseMessage create(Country country) {
		countryRepo.save(country);
		return RESTResponseMessage.commonSuccessMessage(country.getName()+" created successfully");
	}
	@Override
	@Transactional
	public RESTResponseMessage update(Country country, Long id) {		
		Optional<Country> existing = countryRepo.findById(id);
		if(existing.isPresent()) {
			Country savedCountry = existing.get();
			if(savedCountry.getId().equals(country.getId())) {
				savedCountry = commonLogicService.commonUpdate(savedCountry, Country.class);
				savedCountry.setCode(country.getCode());
				savedCountry.setName(country.getName());
				if(country.getPrefix() != null && !country.getPrefix().isEmpty()) {
					savedCountry.setPrefix(country.getPrefix());
				}
				countryRepo.save(savedCountry);
				return RESTResponseMessage.commonSuccessMessage(country.getName()+" updated successfully");
			}
		}
		return RESTResponseMessage.initailFailureMessage();
	}
	@Override
	@Transactional
	public RESTResponseMessage delete(Country country, Long id) {
		Optional<Country> existing = countryRepo.findById(id);
		if(existing.isPresent()) {
			Country savedCountry = existing.get();
			if(savedCountry.getId().equals(country.getId())) {
				savedCountry = commonLogicService.commonDelete(savedCountry, Country.class); 
				countryRepo.save(savedCountry);
				return RESTResponseMessage.commonSuccessMessage(country.getName()+" deleted successfully");
			}
		}
		return RESTResponseMessage.initailFailureMessage();
	}	
	@Override
	public List<IdName> in() {		
		return countryRepo.getActiveIdName(CurrentStatus.ACTIVE);
	}
	@Override
	@Transactional()
	public Country byId(Long id) {
		Optional<Country> c = countryRepo.findById(id);
		Country country = c.isPresent()?c.get():null;
		Hibernate.initialize(country.getState());
		return country;
	}
	
}
