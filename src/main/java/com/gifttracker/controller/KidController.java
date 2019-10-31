package com.gifttracker.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gifttracker.model.FamilyDao;
import com.gifttracker.model.Kid;
import com.gifttracker.model.KidDao;
import com.gifttracker.model.User;

@Controller
@SessionAttributes({"user"})
public class KidController {

	@Autowired
	private FamilyDao daoFamily;
	
	@Autowired
	private KidDao daoKid;
		
	@RequestMapping("/add-a-kid")
	public String displayAddAKid(HttpSession session, Kid newKid) {
		User user = (User) session.getAttribute("user");
		System.out.println("In the add a kid, user is " + user.getUsername());
		System.out.println("In the add a kid, user is " + user.getUserId());
		
		List<String> listOfFamilyNames = daoFamily.getListOfFamilyNames(user.getUserId());
		session.setAttribute("listOfFamilies", listOfFamilyNames);
		return "addData/add-a-kid";	
	}
	
	@RequestMapping(path="/kid-added", method=RequestMethod.POST)
	public String addAKid(HttpSession session, Kid newkid, @RequestParam String familyName, @RequestParam String firstname) {
		System.out.println("in the post method of kid-added");
//		Long familyId = daoFamily.getFamilyIdFromFamilyName(familyName);
		User user = (User) session.getAttribute("user");
		
		Long familyId = daoFamily.getFamilyIdFromUserIdAndFamilyName(user.getUserId(), familyName);
		newkid.setFamilyId(familyId);
		daoKid.saveKid(newkid);
		return "redirect:/dashboard";			
	}
	
	@RequestMapping(path="/see-kids")
	public String seeKids(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Kid> listOfKids = daoKid.getListOfKids(user.getUserId());
		int year = Calendar.getInstance().get(Calendar.YEAR);
		session.setAttribute("currentYear", year);
		session.setAttribute("listOfKids", listOfKids);
		return "displayData/see-kids";
	}
	
	@RequestMapping(path="/edit-a-kid")
	public String editKid(HttpSession session, @RequestParam Long kidId) {
		Kid kid = daoKid.getKidFromId(kidId);
		session.setAttribute("kid", kid);
		return "addData/edit-a-kid";
	}
	
	@RequestMapping(path="/kid-edited", method=RequestMethod.POST)
	public String editAKid(Kid updatedKid, @RequestParam String familyName, @RequestParam String firstname, @RequestParam Long kidId) {
		daoKid.updateKid(kidId, updatedKid);
		return "redirect:/dashboard";			
	}
	
	@RequestMapping(path="/delete-a-kid", method=RequestMethod.POST)
	public String deleteAKid(@RequestParam Long kidId) {
		daoKid.deleteKid(kidId);
		return "redirect:/dashboard";			
	}
	
}
