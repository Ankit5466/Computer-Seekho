package com.Project.Controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project.DTO.ApiResponse;
import com.Project.DTO.PlacedStudentDTO;
import com.Project.Entities.Placement;
import com.Project.Services.PlacementService;

@RestController
@RequestMapping("/placement")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    @GetMapping("/all")
    public ResponseEntity<List<Placement>> getAllPlacements() {
        List<Placement> placements = placementService.getAllPlacements();
        if(placements == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(placements);
    }

    @GetMapping("/getByBatch/{batchId}")
    public ResponseEntity<List<PlacedStudentDTO>> getPlacedStudents(@PathVariable int batchId) {
        List<PlacedStudentDTO> placedStudentDTOs = placementService.getPlacedStudentByBatchId(batchId);
        System.out.println(placedStudentDTOs);
        if(placedStudentDTOs == null){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(placedStudentDTOs);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addPlacement(@RequestBody Placement placement) {
         placementService.createPlacement(placement);
        // if(placement2 == null) {
        //     return ResponseEntity.status(404).body(null);
        // }
        return new ResponseEntity<>(new ApiResponse("Placement Successfull", LocalDateTime.now()),HttpStatus.OK);
    }
}
