package com.api.radio.security;

import com.api.radio.interceptors.FilterCors;
import com.api.radio.interceptors.InterceptorToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class Security  {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(httpSecurityAuthorizeHttpRequestsConfigurer -> {
                    httpSecurityAuthorizeHttpRequestsConfigurer
                            .requestMatchers("/users/login").permitAll()
                            .anyRequest().authenticated();
                })
                .addFilterAfter(new InterceptorToken(), org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new FilterCors(), InterceptorToken.class)
                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.disable())

            .build();
    }

}
