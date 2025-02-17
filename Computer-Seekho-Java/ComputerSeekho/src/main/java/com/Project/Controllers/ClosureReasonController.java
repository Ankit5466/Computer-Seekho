package com.Project.Controllers;

import com.Project.Entities.ClosureReason;
import com.Project.Services.ClosureReasonService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/closureReasons")
public class ClosureReasonController {

    @Autowired
    private ClosureReasonService closureReasonService;

    @GetMapping("/{id}")
    public ResponseEntity<ClosureReason> getClosureReasonById(@PathVariable Integer id) {
        Optional<ClosureReason> closureReason2 = closureReasonService.getClosureReasonById(id);
        if (closureReason2.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(closureReason2.get());
        } {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<ClosureReason>> getAllClosureReasons() {
        List<ClosureReason> closureReasons = closureReasonService.getAllClosureReasons();
        return ResponseEntity.status(HttpStatus.OK).body(closureReasons);
    }

    @PostMapping("/add")
    public ResponseEntity<ClosureReason> addClosureReason(@RequestBody ClosureReason closureReason) {
        ClosureReason closureReason2 = closureReasonService.addClosureReason(closureReason);
        return ResponseEntity.status(HttpStatus.CREATED).body(closureReason2);
    }

    @PutMapping("/update")
    public ResponseEntity<ClosureReason> updateClosureReason(@RequestBody ClosureReason closureReason) {
        boolean result = closureReasonService.updateClosureReason(closureReason);
        if (result) {
            return ResponseEntity.status(HttpStatus.CREATED).body(closureReason);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClosureReason(@PathVariable Integer id) {
        boolean result = closureReasonService.deleteClosureReason(id);
        if (result) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Deleted Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }
    }
}


