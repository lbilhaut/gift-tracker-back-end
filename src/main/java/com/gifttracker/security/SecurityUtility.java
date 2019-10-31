package com.gifttracker.security;

import org.mindrot.jbcrypt.BCrypt;

public class SecurityUtility {
	
	public static String getHashedPassword(String password) {
		// Getting a salt
		String salt = BCrypt.gensalt(10);
        System.out.println("SALT:"+ salt);
        
        // Hashing password and salt
        String pw_hash = BCrypt.hashpw(password,salt);
    	System.out.println("hashed password:" + pw_hash);
		return pw_hash;
	}

	public static boolean checkPassword(String username, String password, String pw_hash) {				
    	if (BCrypt.checkpw(password, pw_hash)) {
//    	    System.out.println("It matches");
    	    return true;
    	}
    	else {
//    	    System.out.println("It does not match");
    	    return false;
    	}
	}

}
