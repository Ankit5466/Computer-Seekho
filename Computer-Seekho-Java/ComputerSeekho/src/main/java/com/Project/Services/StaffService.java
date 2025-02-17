package com.Project.Services;

import java.util.List;

import com.Project.Entities.Staff;

public interface StaffService {
    Staff findByStaffUsername(String staffUsername);
    Staff saveStaff(Staff staff);
    boolean updateStaff(Staff staff);
    boolean deleteByStaffId(int staffId) ;
    List<Staff> getAllStaff();
    int getStaffIdByStaffUsername(String username);
}