package com.capgemini.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {
    @Value("${uname}")
    private String uname;

    @Value("${password}")
    private String password;

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
    	return new InMemoryUserDetailsManager(User
    			.withDefaultPasswordEncoder()
    			.username(uname)
    			.password(password)
    			.roles("USER","ADMIN")
    			.build());
    }
    
}