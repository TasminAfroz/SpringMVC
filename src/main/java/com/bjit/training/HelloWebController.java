package com.bjit.training;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWebController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printHello(Model model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");

		return "hello";
	}

}
