package com.basic.service.common;

import java.util.List;

import com.basic.persitance.model.common.Country;
import com.basic.web.dto.common.IdName;
import com.basic.web.dto.common.RESTResponseMessage;

public interface CountryService {
	public RESTResponseMessage create(Country country); 
	public RESTResponseMessage update(Country country, Long id); 
	public RESTResponseMessage delete(Country country, Long id); 
	public List<IdName> in();
	public Country byId(Long id);
}
