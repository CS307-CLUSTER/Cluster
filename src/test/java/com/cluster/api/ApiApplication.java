package com.cluster.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * Created by shane on 2/16/17.
 *
 * Example of how a RESTful API Service is created
 */

@SpringBootApplication
@EnableOAuth2Sso
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    public void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                    .antMatchers("/", "/login**", "/webjars/**")
                    .permitAll()
                .anyRequest()
                    .authenticated();
    }

}
