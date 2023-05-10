package com.springboot.Boot001;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController   // Return back 
@Qualifier("CurrencyServiceConfig")
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
