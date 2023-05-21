package com.sourabh.webapp01.loginPackage;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class welcomeController 
{
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model)
    {
        model.put("name", getLoggedInUserName());
        return "welcome";
    }

    private String getLoggedInUserName()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        return authentication.getName();
    }
}



/*
 
   private authenticationService authenticationService;

    public loginController(com.sourabh.webapp01.loginPackage.authenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

***************************************************************
 //login?name=sourabh RequestParam
    @RequestMapping(value="loginPage", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name,
    @RequestParam String password, ModelMap model)
    {
        if(authenticationService.authenticate(name, password))
        {
            model.put("name", name);
            // model.put("password", password);
            return "welcome";
        }
        else{
            model.put("errorMessage", "Invalid Credentials Please Try Again");
            return "login";
        }
    }
 */