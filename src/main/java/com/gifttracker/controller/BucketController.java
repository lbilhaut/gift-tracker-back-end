package com.gifttracker.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gifttracker.model.Gift;
import com.gifttracker.model.GiftDao;
import com.gifttracker.utilities.AmazonClient;

@Controller
//@RequestMapping("/storage/")
public class BucketController {
	   private AmazonClient amazonClient;

	    @Autowired
	    BucketController(AmazonClient amazonClient) {
	        this.amazonClient = amazonClient;
	    }
	    
		@Autowired
		private GiftDao daoGift;
	    
		@RequestMapping(path="/uploadFile", method=RequestMethod.POST)
	    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
			System.out.println("In the uploadFile");
	        String url = this.amazonClient.uploadFile(file);
	        Gift gift = new Gift();
	        gift.setGiftName("First gift from AWS");
	        gift.setKidId((long) 1);
	        gift.setGiftPictureName(url);
	        daoGift.saveGift(gift);
	        return "redirect:/dashboard";
	    }

//	    @PostMapping("/uploadFile")
//	    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
//	    	System.out.println("In the uploadFile");
//	    	String fileName = file.getOriginalFilename();
//	        //return this.amazonClient.uploadFile(file);
//	        return "redirect:/dashboard";
//	    }

//	    @DeleteMapping("/deleteFile")
//	    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
//	        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
//	    }


}
