package com.springboot.Boot001;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController   // Return back 
public class CurrencyConfigController 
{

    @Autowired
    private CurrencyServiceConfig config;

    @RequestMapping("/currencyconfig")
    public CurrencyServiceConfig retrieveAllCourses()
    {
        return config;
    }
}
