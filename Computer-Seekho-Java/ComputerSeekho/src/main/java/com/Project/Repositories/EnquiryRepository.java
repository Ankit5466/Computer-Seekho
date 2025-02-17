package com.Project.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Project.Entities.Enquiry;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{
    @Query(value= """
    select * from Enquiry where Enquiry.staff_id = (select staff_id from staff where staff_username = :staffUsername) AND enquiry_is_active = true order by follow_up_date
    """ , nativeQuery = true)
    List<Enquiry> getbystaffList(@Param(value = "staffUsername") String  staffUsername);

    @Modifying
	@Query(value = """
			UPDATE Enquiry SET Enquiry.enquiry_is_active = false WHERE enquiry_id = ?1;
			""", nativeQuery = true)
    void deactivateEnquiry(int enquiryId);

    @Modifying
    @Query("UPDATE Enquiry e SET e.enquirerQuery = :enquirerQuery, e.enquiryCounter = e.enquiryCounter + 1 WHERE e.enquiryId = :enquiryId")
    int updateMessage(@Param("enquiryId") int enquiryId, @Param("enquirerQuery") String enquirerQuery);
}