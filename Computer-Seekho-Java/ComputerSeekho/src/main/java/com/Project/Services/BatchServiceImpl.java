package com.Project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Entities.Batch;
import com.Project.Repositories.BatchRepository;

@Service
public class BatchServiceImpl implements BatchService{

    @Autowired
    BatchRepository batchRepository;

    @Override
    public Batch addBatch(Batch b) {
       return batchRepository.save(b);
    }

    @Override
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    @Override
    public Optional<Batch> getByBatchName(String batchName) {
        return batchRepository.findByBatchName(batchName);
    }

    @Override
    public void delete(int batchId) {
        batchRepository.deleteById(batchId);
    }

    @Override
    public boolean deactivateBatch(int batch_id) {
        Optional<Batch> batchOptional = batchRepository.findById(batch_id);
        if (batchOptional.isPresent()) {
            batchRepository.updateBatchIsActive(batch_id);
            return true;
             
        } else {
            return false;
        }
    }

    @Override
    public List<Batch> getAllActiveBatches() {
        return batchRepository.findAllActiveBatch();
    }

    @Override
    public void activateBatch(int batchId,Boolean batchIsActive) {
        batchRepository.activateBatch(batchIsActive,batchId);
    }

    @Override
    public List<Batch> getByCourseId(int course_id) {
        return batchRepository.findByCourseId(course_id);
    }
    
}
