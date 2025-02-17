package com.Project.Controllers;

import com.Project.DTO.ApiResponse;
import com.Project.Entities.Enquiry;
import com.Project.Services.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/enquiries")
public class EnquiryController {

    @Autowired
    public EnquiryService enquiryService;
    
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createEnquiry(@RequestBody Enquiry enquiry) {
        enquiryService.createEnquiry(enquiry);
        return new ResponseEntity<>(new ApiResponse("Enquiry Added", LocalDateTime.now()),HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Enquiry>> getAllEnquiries() {
        List<Enquiry> enquries =  enquiryService.getAllEnquiries();
        if (enquries != null) {
            return new ResponseEntity<>(enquries, HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);     
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateEnquiry(@PathVariable int id, @RequestBody Enquiry enquiry) {
        Enquiry newEnquiry = enquiryService.getEnquiryById(id);
        if (newEnquiry == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        enquiryService.updateEnquiry(id, enquiry);
        return new ResponseEntity<>(new ApiResponse("Enquiry update successfully", LocalDateTime.now()),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteEnquiry(@PathVariable int id) {
        enquiryService.deleteEnquiry(id);
        return new ResponseEntity<>(new ApiResponse("Enquiry deleted successfully", LocalDateTime.now()), HttpStatus.OK);
    }

    @GetMapping("/getid/{id}")
    public ResponseEntity<Enquiry> getEnquiryById(@PathVariable int id) {
        Enquiry enquiry =  enquiryService.getEnquiryById(id);
        if (enquiry == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(enquiry, HttpStatus.OK);
    }

    @GetMapping("getbystaff/{staffUsername}")
    public ResponseEntity<List<Enquiry>> getEnquiryByStaff(@PathVariable String staffUsername) {
        List<Enquiry> enquries =  enquiryService.getEnquiryByStaff(staffUsername);
        if (enquries != null) {
            return new ResponseEntity<>(enquries, HttpStatus.OK);
        }
        return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);    
    }

    @PutMapping("/updateMessage/{id}")
    public ResponseEntity<ApiResponse> updateMessage(@PathVariable int id,@RequestBody String message) {
       int n= enquiryService.updateMessage(id, message);
       if(n>0)
        return new ResponseEntity<>(new ApiResponse("Message updated successfully", LocalDateTime.now()),HttpStatus.OK);
        else
        return new ResponseEntity<>(new ApiResponse("Message not updated", LocalDateTime.now()),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("deactivate/{id}")
    public ResponseEntity<ApiResponse> deactivateEnquiry(@PathVariable int id,@RequestBody String message){
        enquiryService.deactivateEnquiry(id, message);
        return new ResponseEntity<>(new ApiResponse("Deactivated Successfully", LocalDateTime.now()),HttpStatus.OK);
    }
}


