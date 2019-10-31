package com.gifttracker.developmentarchive;
//package com.techelevator;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import javax.servlet.MultipartConfigElement;
//import javax.servlet.ServletRegistration;
//
//import java.io.File;
//
//public class MyWebInitializer extends
//        AbstractAnnotationConfigDispatcherServletInitializer {
//
//    private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[]{SpringWebMvcConfig.class};
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return null;
//    }
//
//    @Override
//    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//
//        // upload temp file will put here
//    	System.out.println("in the customizeRegistration method");
//    	System.out.println("java.io.tempdir is " + System.getProperty("java.io.tmpdir").toString());
//        File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));
//
//        // register a MultipartConfigElement
//        MultipartConfigElement multipartConfigElement =
//                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
//                        maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);
//
//        registration.setMultipartConfig(multipartConfigElement);
//
//    }
//
//}