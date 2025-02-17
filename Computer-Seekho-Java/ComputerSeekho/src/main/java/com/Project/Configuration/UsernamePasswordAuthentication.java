package com.Project.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.Project.Controllers.AuthController;
import com.Project.Entities.Staff;
import com.Project.Services.StaffService;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsernamePasswordAuthentication implements AuthenticationProvider {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    StaffService service;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pass = authentication.getCredentials().toString();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        
        Staff staff = service.findByStaffUsername(username);

        System.out.println(staff);
        if (staff != null) {
            if(passwordEncoder.matches(pass,staff.getStaffPassword())) {
                authorities.add(new SimpleGrantedAuthority(staff.getStaffRole()));
            }else {
                throw new BadCredentialsException("Invalid password");
            }
        }else {
            throw new BadCredentialsException("User not found with username: " + username);
            
        }
        logger.info("User '{}' signed in successfully with roles: {}", username, authorities);
        logger.info("Login date and time: {}", java.time.LocalDateTime.now());
        return new UsernamePasswordAuthenticationToken(username,pass,authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
