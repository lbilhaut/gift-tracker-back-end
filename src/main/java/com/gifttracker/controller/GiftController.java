package com.gifttracker.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gifttracker.model.FamilyDao;
import com.gifttracker.model.Gift;
import com.gifttracker.model.GiftDao;
import com.gifttracker.model.KidDao;
import com.gifttracker.model.User;
import com.gifttracker.utilities.Constant;
import com.gifttracker.utilities.ImageUtil;
import com.gifttracker.utilities.Printer;

@Controller
public class GiftController {
	
	@Autowired
	private FamilyDao daoFamily;

	@Autowired
	private KidDao daoKid;

	@Autowired
	private GiftDao daoGift;
	
	@RequestMapping("/add-a-gift")
	public String displayAddAGift(HttpSession session, @RequestParam (required = false) Long kidId) {
		System.out.println("In the add a gift page");
		System.out.println("Kid's id is " + kidId);
		User user = (User) session.getAttribute("user");
		List<String> listOfKidNames = daoKid.getListOfKidNames(user.getUserId());
		session.setAttribute("listOfKids", listOfKidNames);
		return "addData/add-a-gift";
	}
	
	@RequestMapping(path="/gift-added", method=RequestMethod.POST)
	public String addAKid(HttpSession session, Gift newGift, @RequestParam String kidFirstname, 
			@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {
		
		User user = (User) session.getAttribute("user");
		
		Long kidId = daoKid.getKidIdFromKidNameAndUserId(kidFirstname, user.getUserId());
		newGift.setKidId(kidId);
	
	    String UPLOADED_FOLDER = Constant.UPLOAD_PATH+kidId+"\\";
        File directory = new File(UPLOADED_FOLDER);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
	    
	    if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
    		return "redirect:/add-a-gift";	
        }

        try {
        	String fileName = file.getOriginalFilename();
        	fileName = ImageUtil.changeJPGExtention(fileName);
        	System.out.println("Original Name is " + file.getOriginalFilename());
        	System.out.println("FileName is " + fileName);
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + fileName);
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message", 
                        "You successfully uploaded '" + file.getOriginalFilename() + "'");
            newGift.setGiftPictureName(fileName);

        } catch (IOException e) {
        	System.out.println("Error while uploading the image");
            e.printStackTrace();
        }
	    
		daoGift.saveGift(newGift);
		return "redirect:/dashboard";			
	}
	
	@RequestMapping(path="/see-gifts")
	public String displayData(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<String> listOfKidNames = daoKid.getListOfKidNames(user.getUserId());
		session.setAttribute("listOfKids", listOfKidNames);
		List<String> listOfFamilies = daoFamily.getListOfFamilyNames(user.getUserId());
		session.setAttribute("listOfFamilies", listOfFamilies);
		return "displayData/see-gifts";
	}
	
	@RequestMapping(path="/previous-gifts-kid", method=RequestMethod.POST)
	public String seeGifts(HttpSession session, @RequestParam String firstname) {
		System.out.println("Want to see gifts to " + firstname);
		session.setAttribute("kidName", firstname);
		User user = (User) session.getAttribute("user");		
		Long kidId = daoKid.getKidIdFromKidNameAndUserId(firstname, user.getUserId());
		session.setAttribute("kidId", kidId);
		session.setAttribute("path", Constant.UPLOAD_PATH);
		List<Gift> listOfGifts = daoGift.getListOfGifts(kidId);
		session.setAttribute("listOfGifts", listOfGifts);		
		System.out.println("List of Gifts:");
		Printer printer = new Printer();
		printer.printGifts(listOfGifts);
		return "displayData/see-gifts-kid";	
	}
	
}
