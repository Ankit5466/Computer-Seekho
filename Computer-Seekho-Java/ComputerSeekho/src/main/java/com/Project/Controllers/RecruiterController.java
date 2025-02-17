package com.Project.Controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.DTO.ApiResponse;
import com.Project.Entities.Recruiter;
import com.Project.Services.RecruiterService;

@RestController
@RequestMapping("/recruiter")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addRecruiter(@RequestBody Recruiter recruiter)
    {
        recruiterService.addRecruiter(recruiter);
        return new ResponseEntity<>(new ApiResponse("Recuiter data added successfully",LocalDateTime.now()),HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Recruiter>> getAllRecruiter()
    {
        List<Recruiter> recruiters = recruiterService.getAllRecruiter();
        if(recruiters == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(recruiters);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRecruiter(@PathVariable int id) 
    {
        recruiterService.deleteRecruiter(id);
        return "Recruiter Deleted";
    }
    
}
