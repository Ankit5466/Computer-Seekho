package com.Project.Controllers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entities.Staff;
import com.Project.Services.StaffService;
import com.Project.DTO.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;




@CrossOrigin(origins = "http://localhost:5173")  
@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/add")
    ResponseEntity<ApiResponse> saveStaff(@RequestBody Staff staff) {
        Staff isAdded =  staffService.saveStaff(staff);
        if (isAdded != null) {
            return new ResponseEntity<>(new ApiResponse("Staff added successfully",LocalDateTime.now()), HttpStatus.CREATED);
        }
            return  new ResponseEntity<>(new ApiResponse("Staff not added",LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);     
    }

    @PutMapping("/update")
    ResponseEntity<ApiResponse> updateStaff(@RequestBody Staff staff) {
        boolean isUpdated = staffService.updateStaff(staff);
        if (isUpdated) {
            return new ResponseEntity<>(new ApiResponse("Staff updated successfully",LocalDateTime.now()), HttpStatus.OK);
        }
            return  new ResponseEntity<>(new ApiResponse("Cannot found staff",LocalDateTime.now()), HttpStatus.NOT_FOUND);     
    }

    @GetMapping("/get/{staffUsername}")
    ResponseEntity<Staff> getStaff(@PathVariable String staffUsername) {
        Staff staff = staffService.findByStaffUsername(staffUsername);
        if (staff != null) {
            return new ResponseEntity<>(staff, HttpStatus.OK);
        }
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);     
    }

    @DeleteMapping("/delete/{staffId}")
    ResponseEntity<ApiResponse> deleteStaff(@PathVariable int staffId) {
        System.out.println(staffId);
        boolean isDeleted = staffService.deleteByStaffId(staffId);
        if (isDeleted) {
            return new ResponseEntity<>(new ApiResponse("Staff deleted successfully",LocalDateTime.now()), HttpStatus.OK);
        } 
            return  new ResponseEntity<>(new ApiResponse("Staff Not Found",LocalDateTime.now()), HttpStatus.NOT_FOUND);     
    }

    @GetMapping("/getAll")
    ResponseEntity<List<Staff>> getAllStaff() {
        return new ResponseEntity<>(staffService.getAllStaff(),HttpStatus.OK);
    }

    @GetMapping("/username/{staffusername}")
    ResponseEntity<ApiResponse>getStaffIdByStaffUsername(@PathVariable String staffusername){
        int id = staffService.getStaffIdByStaffUsername(staffusername);
        System.out.println(id);
        return new ResponseEntity<>(new ApiResponse(new Integer(id).toString(), LocalDateTime.now()), HttpStatus.OK);
    }
    
}