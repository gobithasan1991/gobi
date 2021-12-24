/**
 * 
 */
package com.basic.persitance.model.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author gobithasan.s
 *
 */
@Entity
public class Address extends Default{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8L;

	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@NotBlank(message = "Address line 1 should not be empty")
	@Length(max = 255, message = "Address line 1 must have at maximum 255 characters")
	private String addressLine1;
	
	@Length(max = 255, message = "Address line 2 must have at maximum 255 characters")
	private String addressLine2;
	
	@NotBlank(message = "pincode should not be empty")
	@Length(max = 255, message = "pin must have at maximum 255 characters")
	private String pincode;
	
	@NotNull(message = "Please select state")
	@ManyToOne(fetch = FetchType.LAZY)
	private State state;

	@NotNull(message = "Please select country")
	@ManyToOne(fetch = FetchType.LAZY)
	private Country country;
	
	public Address() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
}
