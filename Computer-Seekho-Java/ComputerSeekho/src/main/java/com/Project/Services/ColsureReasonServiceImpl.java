package com.Project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Entities.ClosureReason;
import com.Project.Repositories.ClosureReasonRepository;

@Service
public class ColsureReasonServiceImpl implements ClosureReasonService{

    @Autowired
    private ClosureReasonRepository closureReasonRepository;
    
    @Override
    public Optional<ClosureReason> getClosureReasonById(Integer id) {
        return closureReasonRepository.findById(id);
    }

    @Override
    public ClosureReason addClosureReason(ClosureReason closureReason) {
        return closureReasonRepository.save(closureReason);
    }

    @Override
    public List<ClosureReason> getAllClosureReasons() {
        return closureReasonRepository.findAll();
    }

    @Override
    public boolean updateClosureReason(ClosureReason closureReason) {
        ClosureReason closureReason2 = closureReasonRepository.findById(closureReason.getClosureReasonId()).get();
        if(closureReason2 != null) {
            closureReason2.setClosureReasonDesc(closureReason.getClosureReasonDesc());
            closureReasonRepository.save(closureReason2);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteClosureReason(int id) {
        ClosureReason closureReason = closureReasonRepository.findById(id).get();
        if(closureReason != null) {
            closureReasonRepository.delete(closureReason);
            return true;
        }
        return false;
    }
    
}
