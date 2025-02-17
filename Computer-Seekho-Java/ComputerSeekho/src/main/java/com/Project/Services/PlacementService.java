package com.Project.Services;

import com.Project.DTO.PlacedStudentDTO;
import com.Project.Entities.Placement;
import java.util.List;

public interface PlacementService {
    Placement createPlacement(Placement placement);
    List<Placement> getAllPlacements();
    List<PlacedStudentDTO> getPlacedStudentByBatchId(int batchId);
}