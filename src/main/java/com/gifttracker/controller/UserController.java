package com.gifttracker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gifttracker.model.User;
import com.gifttracker.model.UserDao;
import com.gifttracker.security.SecurityUtility;
import com.gifttracker.utilities.Constant;

@Controller
public class UserController {
	
	String RELATIVE_PATH = Constant.RELATIVE_PATH;
	
	@Autowired
	private UserDao daoUser;
	
	@RequestMapping(value = {"/dashboard"})
	public String displayDashboard(HttpSession session) {
		if(session.getAttribute("user") == null) {
			System.out.println("No data from user, redirecting to register/login");
			return "redirect:/";
		}
		return "user/dashboard";
	}
	
	@RequestMapping(path="/register")
	public String register(HttpSession session) {
		session.setAttribute("RELATIVE_PATH", "RELATIVE_PATH");
		return "user/register";
	}
	
	@RequestMapping(path="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "welcome";
	}

	
	@RequestMapping(path="/user-signed-up",method=RequestMethod.POST)
	public String addAUser(User user, RedirectAttributes flashScope, @RequestParam String password, HttpSession session) {
		System.out.println("User name is " + user.getUsername());
		System.out.println("User password is " + user.getHashedPassword());
		String hashedPassword = SecurityUtility.getHashedPassword(password);
		user.setHashedPassword(hashedPassword);
		daoUser.saveUser(user);
		session.setAttribute("user", user);
		flashScope.addFlashAttribute("RegistrationSuccess", "You have successfully registered!");
		return "redirect:/dashboard";	
	}

	
	@RequestMapping(path="/login")
	public String login(HttpSession session) {	
		session.setAttribute("RELATIVE_PATH", "RELATIVE_PATH");
		return "user/login";
	}
	
	@RequestMapping(path="/user-logged-in",method=RequestMethod.POST)
	public String loginAUser(@RequestParam String username, RedirectAttributes flashScope, @RequestParam String password, HttpSession session) {
		String message = "";
		List<String> listOfUsernames = daoUser.getListOfUsernames();
		if(listOfUsernames.contains(username)) {
			String pw_hash = daoUser.getHashedPassword(username);
			if(SecurityUtility.checkPassword(username, password, pw_hash)) {
						System.out.println("Password matches the username");
			}
			else {
				System.out.println("Password doesn't match the username");
				message = "Wrong password";
				flashScope.addFlashAttribute("message", message);
				return "redirect:/login";	
			}
		}
		else {
			System.out.println("User not in the database!");
			message = "This username doesn't exist";
			flashScope.addFlashAttribute("message", message);
			return "redirect:/login";	
		}
		flashScope.addFlashAttribute("loginSuccess", "You have successfully logged in!");
		//session.setAttribute("user", username);
		User user = daoUser.getUser(username);
		session.setAttribute("user", user);
		//User loggedUser = daoUser.getUser(user.getUsername(),user.getHashedPassword());
		return "redirect:/dashboard";	
	}

	@RequestMapping(path="/demo")
	public String demo(HttpSession session) {
		User demoUser = daoUser.getUser("Demo");
		session.setAttribute("user", demoUser);
		return "user/dashboard";
	}
	
//	path="/user-logged-in",method=RequestMethod.POST)
//	public String loginAUser(@RequestParam String username, 
//			RedirectAttributes flashScope, 
//			@RequestParam String password, HttpSession session) {
//		String message = "";
		
}
