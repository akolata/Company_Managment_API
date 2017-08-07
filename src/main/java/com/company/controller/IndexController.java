package com.company.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")
public class IndexController {

	public static final String INDEX_PAGE_NAME = "index";
	private static final Logger LOG = Logger.getLogger(IndexController.class);
	
	@GetMapping
	public String showIndexPage(){
		LOG.info("Entering");
		return INDEX_PAGE_NAME;
	}
}
