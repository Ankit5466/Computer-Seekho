package com.Project.Services;

import com.Project.Entities.ClosureReason;

import java.util.List;
import java.util.Optional;

public interface ClosureReasonService {
    Optional<ClosureReason> getClosureReasonById(Integer id);
    ClosureReason addClosureReason(ClosureReason closureReason);
    List<ClosureReason> getAllClosureReasons();
    boolean updateClosureReason(ClosureReason closureReason);
    boolean deleteClosureReason(int id);
}

