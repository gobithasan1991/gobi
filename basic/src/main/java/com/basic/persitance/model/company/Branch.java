package com.basic.persitance.model.company;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.basic.persitance.model.common.Address;
import com.basic.persitance.model.common.Default;
@Entity
public class Branch extends Default{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	@NotBlank(message = "Branch code should not be empty")
	@Length(min = 2, max = 255, message = "code must have at least 2 and maximum 255 characters")
	private String code;
	
	@NotBlank(message = "Branch name should not be empty")
	@Length(min = 2, max = 255, message = "name must have at least 2 and maximum 255 characters")
	private String name;
	
	@NotNull(message = "Address should not be empty")
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	private Address address;
	
	@NotNull(message = "Company should not be empty")
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	private Company company;
	
	@Transient
	private Boolean currentBranch;
	
	public Branch() {
		super();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Boolean getCurrentBranch() {
		return currentBranch;
	}
	public void setCurrentBranch(Boolean currentBranch) {
		this.currentBranch = currentBranch;
	} 
	
}
