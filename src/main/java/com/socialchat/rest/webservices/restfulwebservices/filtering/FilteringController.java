package com.socialchat.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){
        Somebean somebean = new Somebean("value1", "value2", "value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(somebean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("fieldname1","fieldname2") ;
        FilterProvider filters = new SimpleFilterProvider().addFilter("Somebean Filter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/filteringlist")
    public MappingJacksonValue filteringlist(){

        List<Somebean> list = new ArrayList<>();
        list.add(new Somebean("value1","value2","value3"));
        list.add(new Somebean("value4","value5","value6"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(Arrays.asList(list));
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("fieldname1","fieldname3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("Somebean Filter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
