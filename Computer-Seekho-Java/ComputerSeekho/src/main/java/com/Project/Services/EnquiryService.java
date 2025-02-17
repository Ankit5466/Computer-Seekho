package com.Project.Services;

import java.util.List;

import com.Project.Entities.Enquiry;

public interface EnquiryService {
    Enquiry createEnquiry(Enquiry enquiry);
    Enquiry updateEnquiry(int enquiryId, Enquiry enquiry);
    void deleteEnquiry(int enquiryId);
    Enquiry getEnquiryById(int enquiryId);
    List<Enquiry> getAllEnquiries();
    List<Enquiry> getEnquiryByStaff(String staffUsername);
    int updateMessage(int enquiryId,String message);
    void deactivateEnquiry(int enquiryId,String message);
}
