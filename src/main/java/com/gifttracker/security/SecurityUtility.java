package com.gifttracker.security;

import org.mindrot.jbcrypt.BCrypt;

public class SecurityUtility {
	
	public static String getHashedPassword(String password) {
		// Getting a salt
		String salt = BCrypt.gensalt(10);
        
        // Hashing password and salt
        String pw_hash = BCrypt.hashpw(password,salt);
		return pw_hash;
	}

	public static boolean checkPassword(String username, String password, String pw_hash) {				
    	if (BCrypt.checkpw(password, pw_hash)) {
    	    return true;
    	}
    	else {
    	    return false;
    	}
	}

}
