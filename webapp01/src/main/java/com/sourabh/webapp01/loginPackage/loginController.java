package com.sourabh.webapp01.loginPackage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class loginController 
{
    @RequestMapping("loginPage")
    public String gotoLoginPage()
    {
        return "login";
    }
}
