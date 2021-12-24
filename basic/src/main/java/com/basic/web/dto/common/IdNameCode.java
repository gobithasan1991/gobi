package com.basic.web.dto.common;

public class IdNameCode {
	private Long id;
	private String code;
	private String name;
	public IdNameCode() {
		super();
	}
	public IdNameCode(Long id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}
	public IdNameCode(Long id, String code) {
		super();
		this.id = id;
		this.code = code;
	}
	public IdNameCode(String name,Long id) {
		super();
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
}
