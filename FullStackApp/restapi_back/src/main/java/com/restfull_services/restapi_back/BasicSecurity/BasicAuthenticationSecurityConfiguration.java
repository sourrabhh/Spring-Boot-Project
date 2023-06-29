package com.restfull_services.restapi_back.BasicSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

// import static org.springframework.security.config.Customizer.withDefaults;


// @Configuration
public class BasicAuthenticationSecurityConfiguration 
{   // FIlter Chain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        
                http.authorizeHttpRequests(
                        auth -> auth
                            .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                            .anyRequest().authenticated()
                );

                http.httpBasic(Customizer.withDefaults());

                http.sessionManagement(
                                session -> session.sessionCreationPolicy
                                        (SessionCreationPolicy.STATELESS));

                http.csrf().disable();
                        
                return http.build();
    }
    
}
