package com.kdtax.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/personalinformation/exchangerate")
public class ExchangeRateController 
{
	@RequestMapping(method = RequestMethod.GET)
	   public String showHome(Map<String, Object> model) {
	      return "exchangerate";
	   }

}
