package com.gifttracker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gifttracker.model.Family;
import com.gifttracker.model.FamilyDao;
import com.gifttracker.model.User;

@Controller
public class FamilyController {
	
	@Autowired
	private FamilyDao daoFamily;
	
	@RequestMapping(path="/add-a-family")
	public String displayAddAFamily() {
		return "addData/add-a-family";
	}

	@RequestMapping(path="/family-added",method=RequestMethod.POST)
	public String addAFamily(Family newFamily, HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println("User of this session is " + user.getUsername());
		System.out.println("User id is " + user.getUserId());
		daoFamily.saveFamily(newFamily, user.getUserId());
		return "redirect:/dashboard";	
	}
	
	@RequestMapping(path="/see-families")
	public String seeFamilies(HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println("User id is "+ user.getUserId() + " This is " + user.getUsername());
		List<Family> listOfFamilies = daoFamily.getListOfFamilies(user.getUserId());
		session.setAttribute("listOfFamilies", listOfFamilies);
		return "displayData/see-families";
	}
}
