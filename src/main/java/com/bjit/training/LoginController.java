package com.bjit.training;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bjit.training.model.LogIn;
import com.bjit.training.model.User;

@Controller
@SessionAttributes("user")
public class LoginController {
	/*
	 * Add student in model attribute
	 */
	@ModelAttribute("user")
	public User setUpStudentForm1() {
		return new User();
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("logIn", new LogIn());

		return "login";
	}

	@PostMapping("/dologin")
	public String doLogin(@ModelAttribute("user") User user, Model model) {
		
		
		System.out.println("dologin");
		
		
		return "";
		// // Implement your business logic
		// if (user.getEmail().equals("JohnDue@bjit.com") &&
		// user.getPassword().equals("123456")) {
		// // Set student dummy data
		// user.setName("John Due");
		// user.setEmail("JohnDue@bjit.com");
		// user.setId(1);
		//// user.setAge(37);
		// } else {
		// model.addAttribute("message", "Login failed. Try again.");
		// return "login";
		// }
		// return "success";
	}
}