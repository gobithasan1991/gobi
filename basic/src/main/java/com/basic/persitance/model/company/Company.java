package com.basic.persitance.model.company;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;

import com.basic.persitance.model.common.Default;
@Entity
public class Company extends Default{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Length(min = 2, max = 255, message = "code must have at least 2 and maximum 255 characters")
	@Column(unique = true)
	private String name; 
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,optional = false)
	private Branch mainBranch;
	
	public Company() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Branch getMainBranch() {
		return mainBranch;
	}
	public void setMainBranch(Branch mainBranch) {
		this.mainBranch = mainBranch;
	}
	

}
