package com.gifttracker.developmentarchive;

import org.mindrot.jbcrypt.BCrypt;


public class testPassword {

	public static void main(String[] args) {
		System.out.println("Hello World!");
	      
			String password = "perrine";
			
			// Getting a salt
//	        SecureRandom random = new SecureRandom();
//	        byte[] saltArr = new byte[5];
//	        random.nextBytes(saltArr);
//	        String saltString = org.apache.commons.codec.binary.Base64.encodeBase64String(saltArr);
////	        String salt = new String(saltArr, "Cp1252");
//	        System.out.println("SALT:"+saltString);
	        String salt = BCrypt.gensalt(10);
	        System.out.println("SALT:"+ salt);
	        
	        
	        // Hashing password and salt
//	        String pw_hash = BCrypt.hashpw(password,saltString);
	        String pw_hash = BCrypt.hashpw(password,salt);
	    	System.out.println("hashed password:" + pw_hash);


	    	String candidate_password = "perrine";
	    			
	    	if (BCrypt.checkpw(candidate_password, pw_hash))
	    	    System.out.println("It matches");
	    	else
	    	    System.out.println("It does not match");
	    	
	    	
	    	
	      System.out.println("End of program");
	}

}
