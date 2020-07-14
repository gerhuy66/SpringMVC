package com.huy.component;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Component
public class CustomBCryptPasswordEncoder implements PasswordEncoder {
	
	private BCryptPasswordEncoder BCencoder = new BCryptPasswordEncoder();
    @Override
    public String encode(CharSequence arg0){
    	
        try {
            return BCencoder.encode(arg0);
        } catch (Exception e) {
            return "NoSuchAlgorithmException";
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//    	System.out.println("rawPassword:"+rawPassword);
//    	System.out.println("encodedPassword:"+encodedPassword);
//    	System.out.println("encode(rawPassword):"+encode(rawPassword));
    	return BCencoder.matches(rawPassword, encodedPassword);
    }

   

  

}