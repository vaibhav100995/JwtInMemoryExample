package com.example.JwtInMemoryExample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



/*
* This class is used when we want to use In-memory login credentials for user
* and doesn't want to read user details from DB or application.properties file
* */
@Configuration
public class InMemoryConfigCode {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.builder().
                username("Vaibhav")
                .password(passwordEncoder().encode("Vaibhav")).roles("ADMIN").
                build();
        UserDetails userDetails1 = User.builder().username("Abc").password(passwordEncoder().encode("Abc")).
                roles("ADMIN").build();
        return new InMemoryUserDetailsManager(userDetails, userDetails1);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /*
    * this bean we need in AuthController class
    * */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }

}
