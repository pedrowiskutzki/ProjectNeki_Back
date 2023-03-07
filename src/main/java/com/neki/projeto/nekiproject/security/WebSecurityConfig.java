package com.neki.projeto.nekiproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

     @Autowired
     private CustomUserDetailsService customUserDetailsService;

     @Autowired
     private JWTFilter jwtFilter;

     @Autowired
     private PasswordEncoder passwordEncoder;

     @Override
     public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
          authenticationManagerBuilder
                    .userDetailsService(customUserDetailsService)
                    .passwordEncoder(passwordEncoder);
     }

     @Bean
     @Override
     public AuthenticationManager authenticationManagerBean() throws Exception {

          return super.authenticationManagerBean();

     }

     @Override
     protected void configure(HttpSecurity http) throws Exception {

          http
                    .cors().and().csrf().disable()
                    .exceptionHandling()
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/pessoa/login", "/pessoa")
                    .permitAll()
                    .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated();

          http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
     }
}
