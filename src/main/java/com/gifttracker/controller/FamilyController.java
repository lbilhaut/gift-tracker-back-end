package com.gifttracker.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String addAFamily(Family newFamily, HttpSession session, RedirectAttributes redirectAttributes) {
		User user = (User) session.getAttribute("user");
		if(!newFamily.getFamilyName().isEmpty()) {
			daoFamily.saveFamily(newFamily, user.getUserId());
		    redirectAttributes.addFlashAttribute("message", "The " + 
	                newFamily.getFamilyName() + " Family has been successfully saved.");						
		}
		else {
			redirectAttributes.addFlashAttribute("message", "The Family couldn't be saved "
					+ "because it doesn't have a lastname");							
		}
		return "redirect:/dashboard";	
	}
	
	@RequestMapping(path="/see-families")
	public String seeFamilies(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Family> listOfFamilies = daoFamily.getListOfFamilies(user.getUserId());
		session.setAttribute("listOfFamilies", listOfFamilies);
		return "displayData/see-families";
	}
}
