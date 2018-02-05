package com.bjit.training;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bjit.training.configaration.AppConfig;
import com.bjit.training.dao.UserDAO;
import com.bjit.training.dao.UserDAOImpl;
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
	
//	@GetMapping("/")
//	public ModelAndView home() {
//		return new ModelAndView("redirect:/login");	
//	}
	
	@GetMapping(value= {"/", "/login"})
	public ModelAndView login(@ModelAttribute("user") User user) {
		// model.addAttribute("logIn", new LogIn());
		ModelAndView modelAndView = new ModelAndView();
		if(user != null && user.getEmail() != null) {
			System.out.println(user.getEmail());
//			return new ModelAndView("redirect:/login");			
		}else {
			modelAndView.setViewName("login");
		}
		
		
		return modelAndView;
	}

	@PostMapping("/dologin")
	public ModelAndView doLogin(@ModelAttribute("user") User user, BindingResult result, Model model, RedirectAttributes attributes) {
		// Implement your business logic
		User u = userDAO.getSpecificUserByEmail(user.getEmail(), user.getPassword());
		// userLogedin = u;
		// int role = u.getRole();
//HttpSession session;
//System.out.println("Session name"+ session.);
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
			return new ModelAndView("redirect:/details");
			
		} else {
//			model.addAttribute("message", "Email or password incorrect. Try again.");
			
			attributes.addFlashAttribute("message", "Email or password incorrect. Try again.");
			// return "login";
		}
		return new ModelAndView("redirect:/login");
	}
	
	@GetMapping("/details")
	public ModelAndView getDetails(@ModelAttribute("user") User user) {
		if(user == null || user.getEmail() == null) {
			return new ModelAndView("redirect:/login");
		}
		
		if (user.getRole().equals("Admin")) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("user", user);
			modelAndView.setViewName("welcomeAdmin");
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("user", user);
			modelAndView.setViewName("userSessionInfo");
			return modelAndView;
		}
	}
//	
//	@GetMapping("/logout")
//	public ModelAndView logout(ModelMap model,HttpSession session) {
//		session.invalidate();
//		model.clear();
//		return new ModelAndView("redirect:/login");
//	}
////	
//	@GetMapping("/logout")
//	public String logout(@ModelAttribute("user") User user) {
//		user = null;
//		return "login";
//}
	
	
	@GetMapping("/logout")
	public String showLoggedOut(@ModelAttribute("user") User user, HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
//		session.invalidate();
		return "login";
	}
}
