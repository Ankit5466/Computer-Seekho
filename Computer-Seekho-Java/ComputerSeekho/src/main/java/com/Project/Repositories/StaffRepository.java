package com.Project.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Project.Entities.Staff;

import jakarta.transaction.Transactional;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer>{
    Optional<Staff> findByStaffUsername(String staffUsername);    

    @Modifying
    @Transactional
    @Query(value = "UPDATE Staff SET staff_username = :staffUsername ,staff_password = :staffPassword where staff_id = :staffId", nativeQuery = true)
    void updateStaff(@Param("staffUsername") String staffUsername,@Param("staffPassword") String staffPassword, @Param("staffId") int staffId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Staff WHERE staff_username = :staffUsername", nativeQuery = true)
    void deleteByStaffUsername(@Param("staffUsername")String staffUsername);

    @Query(value = """
        select staff_id from staff where staff_username =:username
        """,nativeQuery = true)
    int getStaffIdByStaffUsername(@Param("username") String username);
} 
