package com.xkld.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/xkld")
public class XKLDController 
{
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String showHome(Map<String, Object> model) 
	{
		return "xkld/home";
	}

}
