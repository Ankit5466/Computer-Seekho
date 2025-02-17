package com.Project.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.Entities.ClosureReason;

@Repository
public interface ClosureReasonRepository extends JpaRepository<ClosureReason, Integer>
{ 

}

