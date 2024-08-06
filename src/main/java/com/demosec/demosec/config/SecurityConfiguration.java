package com.demosec.demosec.config;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.demosec.demosec.user.Permission.*;
import static com.demosec.demosec.user.Role.ADMIN;
import static com.demosec.demosec.user.Role.MANAGER;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration {
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    private AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
        http
                .csrf(csrf->csrf.disable())
                .authorizeRequests()
                .requestMatchers("/api/v1/auth/**")
                    .permitAll()
                .requestMatchers("/api/v1/management/**").hasAnyRole(ADMIN.name(),MANAGER.name())
                .requestMatchers(GET,"/api/v1/management/**").hasAnyAuthority(ADMIN_READ.name(),MANAGER_READ.name())
                .requestMatchers(POST,"/api/v1/management/**").hasAnyAuthority(ADMIN_CREATE.name(),MANAGER_CREATE.name())
                .requestMatchers(PUT,"/api/v1/management/**").hasAnyAuthority(ADMIN_UPDATE.name(),MANAGER_UPDATE.name())
                .requestMatchers(DELETE,"/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name(),MANAGER_DELETE.name())

                .requestMatchers("/api/v1/admin/**").hasRole(ADMIN.name())
                .requestMatchers(GET,"/api/v1/management/**").hasAuthority(ADMIN_READ.name())
                .requestMatchers(POST,"/api/v1/management/**").hasAuthority(ADMIN_CREATE.name())
                .requestMatchers(PUT,"/api/v1/management/**").hasAuthority(ADMIN_UPDATE.name())
                .requestMatchers(DELETE,"/api/v1/management/**").hasAuthority(ADMIN_DELETE.name())

                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();


    }

}
