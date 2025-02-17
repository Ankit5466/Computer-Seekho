package com.Project.Controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entities.Batch;
import com.Project.Services.BatchService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/batch")
public class BatchController{

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private BatchService batchService;

    @PostMapping("/add")
    public ResponseEntity<String> addBatch(@RequestBody Batch b)
    {
       Batch added = batchService.addBatch(b);
       if(added!=null)
       {
           return new ResponseEntity<>("Batch added successfully",HttpStatus.CREATED);
       }
       else
       {
           return new ResponseEntity<>("Batch not added",HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Batch>> getAllBatches()
    {
        List<Batch> batchlist= batchService.getAllBatches();
        if(batchlist.size()>0)
        {
            return new ResponseEntity<>(batchlist,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(batchlist,HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/getbycourse/{course_id}")
    public ResponseEntity<List<Batch>> getByCourseId(@PathVariable int course_id)
    {
        List<Batch> batchlist= batchService.getByCourseId(course_id);
        if(batchlist.size()>0)
        {
            return new ResponseEntity<>(batchlist,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(batchlist,HttpStatus.NOT_FOUND);
        }

    }
    
    @GetMapping("/get/{batch_name}")
    public ResponseEntity<Optional<Batch>> getByBatchName(@PathVariable String batch_name)
    {
        logger.info("Searching {}",batch_name);
        Optional<Batch> batch= batchService.getByBatchName(batch_name);
        System.out.println(batch);
        if(batch.isPresent())
        {
            return new ResponseEntity<>(batch,HttpStatus.FOUND);
        }
        else
        {
            return new ResponseEntity<>(batch,HttpStatus.NOT_FOUND);
            
        }
    }
    @GetMapping("/get/all/activebatch")
    public ResponseEntity<List<Batch>> getActiveBatch()
    {
        List<Batch> batchlist= batchService.getAllActiveBatches();
        if(batchlist.size()>0)
        {
            return new ResponseEntity<>(batchlist,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(batchlist,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{batch_id}")
    public ResponseEntity<String> delete(@PathVariable int batch_id)
    {
       batchService.delete(batch_id);
        return new ResponseEntity<>("Batch deleted successfully",HttpStatus.OK);

    }

    @PutMapping("/activate/{batch_id}")
    public ResponseEntity<String> deactivateBatch(@PathVariable int batch_id) {
        Boolean updatedRows = batchService.deactivateBatch(batch_id);
        if (updatedRows) {
            return new ResponseEntity<>("Batch Deactivated Sucesfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Batch not found",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/activate/{batch_id}/{batch_is_active}")
    public ResponseEntity<String> activateBatch(@PathVariable int batch_id,@PathVariable Boolean batch_is_active)
    {
        batchService.activateBatch(batch_id,batch_is_active);
        return ResponseEntity.ok("Batch Activated / Deactivates");
    }
}
