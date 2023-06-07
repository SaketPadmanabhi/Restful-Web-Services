package com.socialchat.rest.webservices.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//RESTAPI
@RestController
public class HelloWorldController {
    //hello-world api returns Hello World

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource){
        this.messageSource = messageSource;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String HelloWorld(){
        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
    public helloworld helloworldbean(){
        return new helloworld("Hello-World-Bean");
    }

    //path-variable
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean/path-variable/{name}")
    public helloworld helloworldPathvariable(@PathVariable String name){
        return new helloworld(String.format("Hello World, %s", name));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-internalionzed")
    public String HelloWorldInternalionzed(){

        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null, "Default Message", locale);
        //locale we get it from a request header
    }
}
