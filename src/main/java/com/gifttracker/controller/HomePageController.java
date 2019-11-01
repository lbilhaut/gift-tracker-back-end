package com.gifttracker.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gifttracker.utilities.Constant;

@Controller 
public class HomePageController {

	String RELATIVE_PATH = Constant.RELATIVE_PATH;

	@RequestMapping(value = {"/"})
	public String displayWelcome(HttpSession session) {
		session.setAttribute("RELATIVE_PATH", RELATIVE_PATH);
		return "welcome";
	}

	@RequestMapping(value = {"/testUploadAWS3"})
	public String displaytestUploadAWS3(HttpSession session) {
		session.setAttribute("RELATIVE_PATH", RELATIVE_PATH);
		return "dev-archive/testUploadAWS3";
	}

}
