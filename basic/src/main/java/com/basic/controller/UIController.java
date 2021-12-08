package com.basic.controller;

import java.util.Scanner;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.basic.service.common.UIService;

@RestController
public class UIController { 
	
	@Autowired
	private UIService uiService;

	@Autowired
	public void setUiService(UIService uiService) {
		this.uiService = uiService;
	}
	
	@Autowired
	public UIController(UIService uiService) {
		super();
		this.uiService = uiService;
	} 

	@GetMapping("/")
	public ModelAndView index() {  	
		
		try (Scanner sc = new Scanner(System.in)){
			
		}
		return new ModelAndView("index");
	}
}
