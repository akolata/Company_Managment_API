package com.company.controller;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/js")
public class JavaScriptHandlingController {

	@GetMapping
	public String showJSForm(){
		return "js-test";
	}
	
	@PostMapping
	@ResponseBody
	public String retrieveXHRPostFromPage(HttpServletRequest req, @RequestParam Map<String,String> allRequestParams,
			@RequestParam(name ="name",required = false) String name){
		
		System.out.println("IN retrieveXHRPostFromPage");
		
		System.out.println("===========================");
		System.out.println("Name = " + name);
		
		System.out.println("===========================");
		System.out.println("allRequestParama");
		for(Map.Entry<String, String> entry : allRequestParams.entrySet()){
			System.out.println("K = " + entry.getKey() + " V = " + entry.getValue());
		}
		
		System.out.println("===========================");
		System.out.println("parametersMap");
		for(Entry<String, String[]> entry : req.getParameterMap().entrySet()){
			System.out.println("K = " + entry.getKey() + " V = " + Arrays.toString(entry.getValue()));
		}
		
		Enumeration<String> attributeNames = req.getAttributeNames();
		
		System.out.println("===========================");
		System.out.println("attributeNames");
		while(attributeNames.hasMoreElements()){
			System.out.println(attributeNames.nextElement());
		}

		return "js-test";
	}
	
	@RequestMapping(method = {RequestMethod.POST}, headers = "x-requested-with=XMLHttpRequest")
	@ResponseBody
	public String retrieveXHRPostFromPageXMLhttpe(@RequestParam(name ="imie",required = false) String name,
			HttpServletRequest req, @RequestParam Map<String,String> allRequestParams){
		System.out.println("IN retrieveXHRPostFromPageXMLhttpe");
		
		System.out.println("===========================");
		System.out.println("Name = " + name);
		
		System.out.println("===========================");
		System.out.println("allRequestParama");
		for(Map.Entry<String, String> entry : allRequestParams.entrySet()){
			System.out.println("K = " + entry.getKey() + " V = " + entry.getValue());
		}
		
		System.out.println("===========================");
		System.out.println("parametersMap");
		for(Entry<String, String[]> entry : req.getParameterMap().entrySet()){
			System.out.println("K = " + entry.getKey() + " V = " + Arrays.toString(entry.getValue()));
		}
		
		Enumeration<String> attributeNames = req.getAttributeNames();
		
		System.out.println("===========================");
		System.out.println("attributeNames");
		while(attributeNames.hasMoreElements()){
			System.out.println(attributeNames.nextElement());
		}

		return "js-test";
	}
}
