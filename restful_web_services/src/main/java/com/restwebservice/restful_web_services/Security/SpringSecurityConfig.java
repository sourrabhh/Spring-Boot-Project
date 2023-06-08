package com.restwebservice.restful_web_services.Security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig 
{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        // 1) All Request should be Authenticated 
        http.authorizeHttpRequests(
            auth -> auth.anyRequest().authenticated());
        
        // 2) If Request isnot authenticated  a web page (Pop Up) is shown
        http.httpBasic(withDefaults());

        // http.csrf().disable();
        return http.build();
    }
}
