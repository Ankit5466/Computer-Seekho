package com.Project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Entities.GetInTouch;
import com.Project.Repositories.GetInTouchRepository;

@Service
public class GetInTouchServiceImpl implements GetInTouchService {


    @Autowired
    private GetInTouchRepository getInTouchRepository;

    @Override
    public void save(GetInTouch getInTouch) {
        getInTouchRepository.save(getInTouch);
    }

    @Override
    public List<GetInTouch> getAll() {
        return getInTouchRepository.findAll();
    }

    @Override
    public void deleteById(int getInTouchId) {
        getInTouchRepository.deleteById(getInTouchId);
    }
    
}
