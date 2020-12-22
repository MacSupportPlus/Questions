package com.macsupport.questions.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.macsupport.questions.Models.User;
import com.macsupport.questions.Services.UserService;
import com.macsupport.questions.Validators.UserValidator;

@Controller
public class UserController {
	  private final UserService userService;
	  private final UserValidator userValidator;
	    
	    public UserController(UserService userService, UserValidator userValidator) {
	        this.userService = userService;
	        this.userValidator = userValidator;
	     
	    }
	    @RequestMapping(path={"/","/registration"})
	    public String registerForm(@ModelAttribute("user") User user) {
	        return "registrationPage.jsp";
	    }
	    @RequestMapping("/login")
	    public String login() {
	        return "loginPage.jsp";
	    }
	 
	    @RequestMapping(value="/registration", method=RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes redirectAttributes) {
	        // if result has errors, return the registration page (don't worry about validations just now)
	    	 userValidator.validate(user, result);
	         if(result.hasErrors()) {
	             return "registrationPage.jsp";
	    	} else {
	    		
	    			User saveUser = userService.registerUser(user);
	    			session.setAttribute("user_id", saveUser.getId());
	    			return "redirect:/questions";
	    		} 
	    }
	    
	    @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
	    	        // if the user is authenticated, save their user id in session
	    	boolean isValid = userService.authenticateUser(email, password);
	    	if(isValid == true) {
	    		User validUser = userService.findByEmail(email);
	    		session.setAttribute("user_id", validUser.getId());
	    		return "redirect:/questions";
	    		
	    	} else { 
	    	        // else, add error messages and return the login page
	    		redirectAttributes.addFlashAttribute("login_errors", "Invalid email/password combination!");
	    		return "redirect:/login";
	    	    }
	    }
	    @RequestMapping("/logout")
	    public String logout(HttpSession session) {
	        // invalidate session
	    	session.invalidate();
	        // redirect to login page
	    	return "redirect:/login";
	    }
	    
	   
}
