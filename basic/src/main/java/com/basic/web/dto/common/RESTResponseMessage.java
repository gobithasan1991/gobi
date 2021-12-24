package com.basic.web.dto.common;

import java.util.List;

import com.basic.extensible.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RESTResponseMessage {
	private Long id;
	private ResponseStatus code;
	private String message;
	private String desc;
	private List<Long> ids;
	public static RESTResponseMessage initailFailureMessage() {
		return new RESTResponseMessage(ResponseStatus.ERROR, "something went wrong");
	}
	public static RESTResponseMessage commonSuccessMessage(String msg) {
		return new RESTResponseMessage(ResponseStatus.SUCCESS, msg);
	}
	public RESTResponseMessage() {
		super();
	}
	public RESTResponseMessage(Long id, ResponseStatus code) {
		super();
		this.id = id;
		this.code = code;
	}	
	public RESTResponseMessage(ResponseStatus code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public RESTResponseMessage(Long id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	public RESTResponseMessage(Long id, ResponseStatus code, String message) {
		super();
		this.id = id;
		this.code = code;
		this.message = message;
	}
	public RESTResponseMessage(Long id, ResponseStatus code, String message, String desc) {
		super();
		this.id = id;
		this.code = code;
		this.message = message;
		this.desc = desc;
	}
	public RESTResponseMessage(Long id, ResponseStatus code, String message, String desc, List<Long> ids) {
		super();
		this.id = id;
		this.code = code;
		this.message = message;
		this.desc = desc;
		this.ids = ids;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ResponseStatus getCode() {
		return code;
	}
	public void setCode(ResponseStatus code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<Long> getIds() {
		return ids;
	}
	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
	
	
}
