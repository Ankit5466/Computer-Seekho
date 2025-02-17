package com.project.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Services.EmailSenderService;

@RestController
public class EmailController {
	@Autowired
	private EmailSenderService service;

	@PostMapping("/email")
	public ResponseEntity<String> sendEmail(@RequestBody Map<String, Object> emailRequest) {
		try {
			String to = (String) emailRequest.get("to");
			String studentName = (String) emailRequest.get("studentName");
			service.sendAdmissionEmail(to, studentName);
			return ResponseEntity.status(HttpStatus.OK).body("Email sent successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to send email: " + e.getMessage());
		}
	}

	@PostMapping("/emailpayment")
	public ResponseEntity<String> sendEmailPayment(@RequestBody Map<String, Object> emailRequest) {
		try {
			service.sendEmailPayment(emailRequest);
			return ResponseEntity.status(HttpStatus.OK).body("Email sent successfully");
		} 
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email: " + e.getMessage());
		}
	}
}
