package com.sourabh.webapp01.loginPackage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class loginController 
{
    private authenticationService authenticationService;

    public loginController(com.sourabh.webapp01.loginPackage.authenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value="loginPage", method = RequestMethod.GET)
    public String gotoLoginPage()
    {
        return "login";
    }

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

        else
        {
            model.put("errorMessage", "Invalid Credentials Please Try Again");
            return "login";
        }
    }
}
