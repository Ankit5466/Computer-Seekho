package com.Project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.Project.DTO.ApiResponse;
import com.Project.DTO.PaymentDTO;
import com.Project.Entities.Payment;
import com.Project.Entities.Student;
import com.Project.Services.PaymentService;
import com.Project.Services.StudentService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createPayment(@RequestBody Payment payment) {
        Student student = studentService.getStudentById(payment.getStudent().getStudentId()).get();
        if(student.getPaymentDue()-payment.getAmount()<0){
            return new ResponseEntity<>(new ApiResponse("Payment Amount Exceeded Payment Dues", LocalDateTime.now()),HttpStatus.NOT_ACCEPTABLE);
        }
        Payment payment2 = paymentService.savePayment(payment);
        PaymentDTO paymentDTO = paymentService.getPaymentDTOById(payment2.getPaymentId());
        String emailServiceUrl = "http://localhost:9003/emailpayment";
        Map<String, Object> emailRequest = new HashMap<>();
        System.out.println(paymentDTO.getStudentEmail());
        emailRequest.put("email", paymentDTO.getStudentEmail());
        emailRequest.put("amount", String.valueOf(paymentDTO.getAmount()));
        emailRequest.put("date", paymentDTO.getPaymentDate().toString());
        emailRequest.put("Type", paymentDTO.getPaymentTypeDesc());
        emailRequest.put("studentName", paymentDTO.getStudentName());
        emailRequest.put("paymentId", String.valueOf(payment2.getPaymentId()));
        try {
            restTemplate.postForObject(emailServiceUrl, emailRequest, String.class);
           
        } catch (Exception e) {
            System.err.println("An error occurred while sending the email: " + e.getMessage());
        }
        if (paymentDTO != null) {
            return new ResponseEntity<>(new ApiResponse("Payment successfully",LocalDateTime.now()), HttpStatus.CREATED);
        }
        return  new ResponseEntity<>(new ApiResponse("Payment unsuccessfull",LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    // @PutMapping("/{id}")
    // public ResponseEntity<Payment> updatePayment(@PathVariable int id, @RequestBody Payment paymentDetails) {
    //     Payment payment = paymentService.getPaymentById(id);
    //     if (payment != null) {
    //         payment.setPaymentTypeId(paymentDetails.getPaymentTypeId());
    //         payment.setPaymentDate(paymentDetails.getPaymentDate());
    //         payment.setStudent(paymentDetails.getStudent());
    //         payment.setAmount(paymentDetails.getAmount());
    //         Payment updatedPayment = paymentService.updatePayment(payment);
    //         return ResponseEntity.ok(updatedPayment);
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deletePayment(@PathVariable int id) {
    //     Payment payment = paymentService.getPaymentById(id);
    //     if (payment != null) {
    //         paymentService.deletePayment(id);
    //         return ResponseEntity.noContent().build();
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }



    //as we are not using update and delete payment methods in this project
    //we have commented them out
