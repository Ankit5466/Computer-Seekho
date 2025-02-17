package com.Project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.DTO.PlacedStudentDTO;
import com.Project.Entities.Placement;
import com.Project.Repositories.PlacementRepository;

@Service
public class PlacementServiceImpl implements PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    @Override
    public Placement createPlacement(Placement placement) {
        return placementRepository.save(placement);
    }

    @Override
    public List<Placement> getAllPlacements() {
        return placementRepository.findAll();
    }

    @Override
    public List<PlacedStudentDTO> getPlacedStudentByBatchId(int batchId) {
        return placementRepository.findByBatchId(batchId);
    }
}
