package com.Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.Entities.Recruiter;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter,Integer> {
    
}
