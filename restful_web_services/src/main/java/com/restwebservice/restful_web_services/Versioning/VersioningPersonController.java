package com.restwebservice.restful_web_services.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController 
{
    @GetMapping(path = "/v1/person")
    public PersonV1 getFirstVersionOfPerson()
    {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/v2/person")
    public PersonV2 getSecondVersionOfPerson()
    {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter()
    {
        return new PersonV1("Bob Charlie Version 1");
    }

    @GetMapping(path = "person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter()
    {
        return new PersonV2(new Name("Bob V2", "Charlie V2"));
    }

    // CUSTOM  Header VERSIONING
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader()
    {
        return new PersonV1("Bob Charlie Header 1");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader()
    {
        return new PersonV2(new Name("Bob Header v2", "Charlie Header v2"));
    }

    // Media Type Versioning AKA ACCEPT HEADER
    @GetMapping(path = "/person/acceptheader", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader()
    {
        return new PersonV1("Bob Charlie Accept Header 1");
    }

    @GetMapping(path = "/person/acceptheader", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader()
    {
        return new PersonV2(new Name("Bob Accept Header v2", "Charlie Accept Header v2"));
    }

}
