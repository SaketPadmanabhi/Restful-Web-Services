package com.socialchat.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //all requests are authenticated
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        http.httpBasic(Customizer.withDefaults()); //basic authentication

        //disable CSRF, that do not let us allow the post and put requests
        http.csrf().disable();

        return http.build();
    }
    //overriding the default filter-chain given by spring security.
    //If this is not done then it pops up a page of login for authorization using a username and password

}
