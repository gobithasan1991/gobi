package com.basic.persitance.model.company;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.basic.persitance.model.common.Address;
import com.basic.persitance.model.common.Default;
@Entity
public class Employee extends Default{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	
	@Column(nullable = false, unique = true, updatable = false)
	private String empid;
	
	@NotBlank(message = "Please Enter first name.")
	@Length(min = 2, max = 255, message = "first name must have at least 2 and maximum 255 characters")
	private String firstName;
	
	@NotBlank(message = "Please Enter last name.")
	@Length(min = 1, max = 255, message = "last name must have at least 1 and maximum 255 characters")
	private String lastName;
	
	@NotBlank(message = "Please Enter display name.")
	@Length(min = 2, max = 255, message = "Display name must have at least 2 and maximum 255 characters")
	private String displayName;
	
	@NotBlank(message = "Please Enter phone number.")
	@Length(min = 2, max = 255, message = "full name must have at least 2 and maximum 255 characters")
	private String phone;
	
	@Length(max = 255, message = "Email must have at maximum 255 characters")
	@Email(message = "Please provide a valid Email")
	@NotBlank(message = "Please provide an email")
	private String email;
	
	@NotNull(message = "Address should not be empty")
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	private Address address;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "employee_branch", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "branch_id"))
	private Set<Branch> employeeBranch;
	
	public Employee() {
		super();
	}
	
}
