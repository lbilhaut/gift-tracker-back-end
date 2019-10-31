package com.gifttracker.developmentarchive;
//package com.gifttracker.controller;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.gifttracker.utilities.Constant;
//
//@Controller
//public class UploadFileController {
//    
//	@RequestMapping(path="/testupload")
//	public String displayDownload() {
//		return "testUpload";
//	}
//
//	@RequestMapping(value = "/upload", method = RequestMethod.POST)
////    @PostMapping("/upload") // //new annotation since 4.3
//    public String singleFileUpload(@RequestParam("file") MultipartFile file,
//                                   RedirectAttributes redirectAttributes) {
//        if (file.isEmpty()) {
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            return "redirect:uploadStatus";
//        }
//
//        try {
//
//            // Get the file and save it somewhere
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(Constant.UPLOAD_PATH + file.getOriginalFilename());
//            Files.write(path, bytes);
//            redirectAttributes.addFlashAttribute("message", 
//                        "You successfully uploaded '" + file.getOriginalFilename() + "'");
//
//        } catch (IOException e) {
//        	System.out.println("Error while uploading the image");
//            e.printStackTrace();
//        }
//
//        return "redirect:/uploadStatus";
//    }
//
////    @GetMapping("/uploadStatus")
//	@RequestMapping("/uploadStatus")
//	public String uploadStatus() {
//        return "uploadStatus";
//    }	
//}
