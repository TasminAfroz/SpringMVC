package com.bjit.training;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bjit.training.configaration.AppConfig;
import com.bjit.training.dao.UserDAO;
import com.bjit.training.dao.UserDAOImpl;
import com.bjit.training.model.LogIn;
import com.bjit.training.model.User;

@Controller
@SessionAttributes("user")
public class LoginController {
	/*
	 * Add student in model attribute
	 */

	AnnotationConfigApplicationContext at = new AnnotationConfigApplicationContext(AppConfig.class);
	UserDAO userDAO = at.getBean(UserDAOImpl.class);

	@ModelAttribute("user")
	public User setUpStudentForm1() {
		return new User();
	}

	@GetMapping("/login")
	public String login(Model model) {
		// model.addAttribute("logIn", new LogIn());

		return "login";
	}

	@PostMapping("/dologin")
	public ModelAndView doLogin(@ModelAttribute("user") User user, BindingResult result, Model model) {
		// Implement your business logic
		User u = userDAO.getSpecificUserByEmail(user.getEmail(), user.getPassword());
		// userLogedin = u;
		System.out.println(u.getName() + "from do login ");
		System.out.println(u.getGender() + "role from do login ");
		// int role = u.getRole();

		if (u != null && user.getPassword().equals(u.getPassword())) {
			// // Set student dummy data
			//// System.out.println(user);
			user.setName(u.getName());

			user.setEmail(u.getEmail());
			user.setGender(u.getGender());
			// user.setAge(u.getAge());
			user.setPassword(u.getPassword());
			// System.out.println(user.getRole());
			user.setRole(u.getRole());
			user.setAddress(u.getAddress());
			System.out.println(user);
			if (u.getRole().equals("Admin")) {
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.addObject("user", u);
				modelAndView.setViewName("welcomeAdmin");
				return modelAndView;
			} else {
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.addObject("user", user);
				modelAndView.setViewName("userSessionInfo");
				return modelAndView;
			}
		} else {
			model.addAttribute("message", "Email or password incorrect. Try again.");
			// return "login";
		}
		return new ModelAndView("redirect:/login");
	}
	
	@GetMapping("/logout")
	public String logout(@ModelAttribute("user") User user) {
		user = null;
		return "login";
	}
}
