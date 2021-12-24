package com.basic.persitance.model.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.basic.persitance.model.common.Default;
@Entity
public class Role extends Default{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Length(min = 4,max = 255,message = "Role length shoult be 4 to 255")
	@NotBlank(message = "role shoult not be empty")
    private String role;
	
	
	public Role() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + "]";
	} 
	
}
