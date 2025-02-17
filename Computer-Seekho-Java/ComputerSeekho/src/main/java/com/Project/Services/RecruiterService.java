package com.Project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Entities.Recruiter;
import com.Project.Repositories.RecruiterRepository;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    public Recruiter addRecruiter(Recruiter recruiter)
    {
        return recruiterRepository.save(recruiter);
    }

    public List<Recruiter> getAllRecruiter()
    {
        return recruiterRepository.findAll();
    }

    public void deleteRecruiter(int id)
    {
        recruiterRepository.deleteById(id);
    }
    
}
