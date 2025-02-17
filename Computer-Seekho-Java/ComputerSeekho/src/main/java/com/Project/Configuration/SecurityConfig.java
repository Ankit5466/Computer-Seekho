package com.Project.Configuration;



import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.Project.Filter.JWTTokenValidatorFilter;
import com.Project.Filter.JWTokenGenerationFilter;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class SecurityConfig {

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
            security.csrf(crf->crf.disable());
            
            security.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.NEVER));
            security.addFilterAfter(new JWTokenGenerationFilter(), BasicAuthenticationFilter.class);
            security.addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class);

            security.authorizeHttpRequests(Auth-> Auth
            .requestMatchers("/auth/signIn").authenticated()
            // .requestMatchers("/staff/**").hasAnyRole("TEACHING", "NON_TEACHING")
            // .requestMatchers("/enquiries/**").hasAnyRole("TEACHING", "NON_TEACHING")
            // .requestMatchers("/payment/**").hasAnyRole("TEACHING", "NON_TEACHING")
            // .requestMatchers("/paymentTypes/**").hasAnyRole("TEACHING", "NON_TEACHING")
            // .requestMatchers("/student/**").hasAnyRole("TEACHING", "NON_TEACHING")          
            .requestMatchers("/**").permitAll());
            security.httpBasic(Customizer.withDefaults());

            security.cors(csr->csr.configurationSource(new CorsConfigurationSource() {
                @Override
                public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                     CorsConfiguration cfg = new CorsConfiguration();
                     cfg.setAllowedOrigins(Arrays.asList("http://localhost:5173", "http://localhost:5174"));
                     cfg.setAllowedMethods(Collections.singletonList("*"));
                     cfg.setAllowedHeaders(Collections.singletonList("*"));
                     cfg.setAllowCredentials(true);
                     cfg.setExposedHeaders(Collections.singletonList("Authorization"));
                     cfg.setMaxAge(3600L);
                     return cfg;
                }
            }));
            return security.build();
    }

    @Bean
    PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}