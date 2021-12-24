package com.basic.persitance.model.security;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.basic.persitance.model.common.Default;
import com.basic.persitance.model.company.Branch;
import com.basic.persitance.model.company.Employee;

@Entity
public class User extends Default {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	
	@Size(min = 5, max = 255, message = "Your user name must have at least 5 and maximum 255 characters")
	@NotBlank(message = "*Please provide a user name")
	private String userName; 
	
	@Size(max = 255, message = "Email must have at maximum 255 characters")
	@Email(message = "Please provide a valid Email")
	@NotBlank(message = "Please provide an email")
	private String email; 
	

	@Size(min = 5, max = 255, message = "Your password must have at least 5 and maximum 255 characters")
	@NotBlank(message = "Please provide your password")
	private String password;
	
	@Size(max = 255, message = "Your name must have at maximum 255 characters")
	@NotBlank(message = "Please provide your name")
	private String name; 
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "user_branch", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "branch_id"))
	private Set<Branch> userBranch;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,optional = true)
	private Employee employee;

	public User() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Branch> getUserBranch() {
		return userBranch;
	}

	public void setUserBranch(Set<Branch> userBranch) {
		this.userBranch = userBranch;
	} 
	
}
