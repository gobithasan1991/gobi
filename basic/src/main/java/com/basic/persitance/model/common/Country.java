package com.basic.persitance.model.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
@Entity
public class Country extends Default{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6L; 
	
	@NotBlank(message = "Please Enter country name.")
	@Length(min = 2, max = 255, message = "name must have at least 2 and maximum 255 characters")
	@Column(unique = true)
	private String name;
	
	@NotBlank(message = "Please Enter country code.")
	@Length(min = 2, max = 255, message = "code must have at least 2 and maximum 255 characters")
	@Column(unique = true)
	private String code;
	
	@NotBlank(message = "Please Enter prefix.")
	private String prefix;
	
	@ManyToOne(optional = true,fetch = FetchType.LAZY)
	private State state;

	public Country() {
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

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
}
