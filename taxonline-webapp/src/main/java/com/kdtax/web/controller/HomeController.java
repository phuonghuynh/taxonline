package com.kdtax.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController 
{
	@RequestMapping(method = RequestMethod.GET)
	public String showHome(Map<String, Object> model) 
	{
		model.put("cars", "blad blad"); 
		
		return "welcome";
	}
	
	@RequestMapping(value="/testPost", method = RequestMethod.POST)
	public String testPost(Map<String, Object> model) 
	{
		model.put("cars", "blad blad"); 
		
		return "welcome";
	}

}
