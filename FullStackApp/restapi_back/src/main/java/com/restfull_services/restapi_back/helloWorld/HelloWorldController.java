package com.restfull_services.restapi_back.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController
{
    @GetMapping(path = "/helloworld")
    public String helloWorld()
    {
        return "Hello World ";
    }

    @GetMapping(path = "/helloworldbean")
    public HelloWorldBean helloWorldBean()
    {
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping(path = "/helloworld/pathvariable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hello World, %s" ,  name));
    }

     @GetMapping(path = "/basicauth")
    public String basicAuthCheck()
    {
        return "Success";
    }
}
