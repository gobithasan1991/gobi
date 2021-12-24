package com.basic.web.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basic.persitance.model.common.Country;
import com.basic.service.common.CountryService;
import com.basic.web.dto.common.IdName;
import com.basic.web.dto.common.RESTResponseMessage;

@RestController
@RequestMapping(value = "/country")
public class CountryController {
	private CountryService countryService;
	@Autowired
	public CountryController(CountryService countryService) {
		super();
		this.countryService = countryService;
	}
	@PostMapping("/create")
	public RESTResponseMessage create(@RequestParam Country country) {
		return countryService.create(country);
	}
	@PutMapping("/{id}/update")
	public RESTResponseMessage update(@PathVariable Long id,@RequestParam Country country) {
		return countryService.update(country, id);
	}
	@DeleteMapping("/{id}/delete")
	public RESTResponseMessage delect(@PathVariable Long id,@RequestParam Country country) {
		return countryService.update(country, id);
	}
	
	@GetMapping("/in")
	public List<IdName> in(){
		return countryService.in();
	}

	@GetMapping("/by-id/{id}")
	public Country byId(@PathVariable("id") Long id){
		return countryService.byId(id);
	}
}
