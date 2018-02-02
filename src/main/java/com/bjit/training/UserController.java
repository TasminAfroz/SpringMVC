package com.bjit.training;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bjit.training.configaration.AppConfig;
import com.bjit.training.dao.UserDAO;
import com.bjit.training.dao.UserDAOImpl;
import com.bjit.training.model.User;

@Controller
public class UserController {
	
	

    @Autowired
    private UserDAO userDAO;
	@GetMapping("/user")
	public String userForm(Model model) {
		model.addAttribute("user", new User());
		return "userForm";
	}

	@PostMapping("/saveUser")
	public ModelAndView saveUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
		System.out.println("ID     "+user.getId());
//	AnnotationConfigApplicationContext at = new AnnotationConfigApplicationContext(AppConfig.class);
//		UserDAO userDAO = at.getBean(UserDAOImpl.class) ;
		if (result.hasErrors()) {
			return  new ModelAndView("redirect:/userForm");
		}
		userDAO.save(user);
		model.addAttribute("message", "Action Completed");
//		return "userDetails";
		 return new ModelAndView("redirect:/usersDetails");
	}
	
	

	@RequestMapping(value = "/usersDetails")
	public ModelAndView userList(ModelAndView model) throws IOException{
	    List<User> userList = userDAO.userDetails();
	    for (int i=0;i<userList.size();i++) {
	    	System.out.println(userList.get(i).getName());
	    }
//	    System.out.println(userList.get(1));
//	    model.
	    model.addObject("usrdetails", userList);
	    model.setViewName("userDetails");
	 
	    return model;
	}
	
	  @RequestMapping(value = "/edit/{id}")
	    public ModelAndView editUser(@ModelAttribute("user") User user,@PathVariable("id") int id)
	    {
	        ModelAndView model = new ModelAndView("userDetails");
	        System.out.println(id);
	        
	        user = userDAO.getSpecificUser(id);
//	        List userList = userDAO.userDetails();
//	        System.out.println(user.getAddress()+"from controller");
//	        model.addObject("userList",userList);
	        
	        model.addObject("user",user);
	        model.setViewName("userForm");
	        
	        return model;
	    }
	  
	  
	  @RequestMapping(value = "/delete/{id}")
	    public ModelAndView deleteUser(@ModelAttribute("user") User user,@PathVariable("id") int id)
	    {
//	        ModelAndView model = new ModelAndView("userDetails");
//	        System.out.println(id);
	        
	        userDAO.deleteSpecificUser(id);
//	        List userList = userDAO.userDetails();
//	        System.out.println(user.getAddress()+"from controller");
//	        model.addObject("user",user);
	        
	        return new ModelAndView("redirect:/usersDetails");
	    }


}