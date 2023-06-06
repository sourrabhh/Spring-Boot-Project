package com.restwebservice.restful_web_services.Filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController 
{
    // Dynamic Filtering 
    @GetMapping("/filtering")
    public MappingJacksonValue filtering()
    {
        SomeBean someBeanObj = new SomeBean("Value1","Value2","Value3");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeanObj);
        
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");

        FilterProvider filtersObj = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filtersObj);

        return mappingJacksonValue; 
    }

    @GetMapping("/filteringList") //field2 , field3
    public MappingJacksonValue filteringList()
    {
        List<SomeBean> listObj= Arrays.asList(new SomeBean("Value1","Value2","Value3"),
        new SomeBean("Value4","Value5","Value6")) ;

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(listObj);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filterObj = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        mappingJacksonValue.setFilters(filterObj);
        return mappingJacksonValue;
    }
}
