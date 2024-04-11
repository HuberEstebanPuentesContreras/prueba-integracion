package com.example.integracion.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .exceptionHandling() 
                .authenticationEntryPoint(jwtAuthenticationEntryPoint) 
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests() 
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/security/country/create").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET,"/api/security/country/get").hasAnyAuthority("ADMIN" , "USER")
                .requestMatchers(HttpMethod.GET,"/api/security/country/getId/**").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/security/country/update/**").hasAuthority("ADMIN")
                
                
                .requestMatchers(HttpMethod.POST, "/api/security/payment/create").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET,"/api/security/payment/get").hasAnyAuthority("ADMIN" , "USER")
                .requestMatchers(HttpMethod.GET,"/api/security/payment/getId/**").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/security/payment/delete/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/security/payment/update/**").hasAuthority("ADMIN")
                
                .requestMatchers(HttpMethod.POST, "/api/security/language/create").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET,"/api/security/language/get").hasAnyAuthority("ADMIN" , "USER")
                .requestMatchers(HttpMethod.GET,"/api/security/language/getId/**").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/security/laguage/update/**").hasAuthority("ADMIN")
                       
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
