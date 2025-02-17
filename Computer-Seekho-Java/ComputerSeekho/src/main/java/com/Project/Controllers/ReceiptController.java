package com.Project.Controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.DTO.ApiResponse;
import com.Project.Entities.Receipt;
import com.Project.Services.ReceiptService;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {
    @Autowired
    private ReceiptService receiptService;
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Receipt> getReceiptById(@PathVariable int receiptId) {
        Receipt receipt = receiptService.getReceiptById(receiptId).get();
        if(receipt == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(receipt);
    }

    @GetMapping("/all")
    public List<Receipt> getAllReceipts() {
        return receiptService.getAllReceipts();
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addReceipt(Receipt receipt) {
        Receipt receipt2 = receiptService.addReceipt(receipt);
        if(receipt2 == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Receipt added successfully", LocalDateTime.now()));
    }
}