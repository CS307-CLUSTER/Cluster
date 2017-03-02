package com.cluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@SpringBootApplication
@EnableOAuth2Sso
public class ClusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClusterApplication.class, args);
    }

    public void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                    .antMatchers("/", "/login**", "/webjars/**")
                    .permitAll()
                .anyRequest()
                    .authenticated()
        .and().logout().logoutSuccessUrl("/test.html").permitAll()
        .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }
}
