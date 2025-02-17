package com.Project.Controllers;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.DTO.ApiResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @PostMapping("/signIn")
    ResponseEntity<ApiResponse> signIn() {
        return ResponseEntity.ok(new ApiResponse("Sign In successfull", LocalDateTime.now()));
    }

}
