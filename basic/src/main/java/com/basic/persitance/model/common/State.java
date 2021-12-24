package com.basic.persitance.model.common;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"code", "country_id"}))
public class State extends Default{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7L; 
	
	@NotBlank(message = "Please Enter state name.")
	private String name;
	
	@NotBlank(message = "Please Enter state code.") 
	private String code;
	
	@NotNull(message = "Please select country.")
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	private Country country;

	public State() {
		super();
	} 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}
