package com.restwebservice.restful_web_services.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController 
{
    //@RequestMapping(method = RequestMethod.GET, path = "/helloworld") //alternative
    @GetMapping(path = "/helloworld")
    public String helloWorld()
    {
        return "Hello World";
    }

    @GetMapping(path = "/helloworldbean")
    public HelloWorldBean helloWorldBean()
    {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/helloworldbean/pathvariable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hello World %s", name));
    }
}
