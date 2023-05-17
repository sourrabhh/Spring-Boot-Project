package com.sourabh.webapp01.loginPackage;

import org.springframework.stereotype.Service;

@Service
public class authenticationService 
{

    public boolean authenticate(String username, String password)
    {
        boolean isValidUserName =  username.equalsIgnoreCase("sourabh");
        boolean isValidPassword =  password.equals("dummy");

        return isValidUserName && isValidPassword;
    }
}
