package com.Project.Repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Project.Entities.Receipt;

@Repository
public interface ReceiptRepositories extends JpaRepository<Receipt, Integer> {
    
}
