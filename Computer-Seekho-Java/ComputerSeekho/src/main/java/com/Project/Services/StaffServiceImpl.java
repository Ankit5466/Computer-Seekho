package com.Project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Project.Entities.Staff;
import com.Project.Repositories.StaffRepository;
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffRepository staffRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Staff saveStaff(Staff staff) {
        staff.setStaffRole("ROLE_"+staff.getStaffRole());
        staff.setStaffUsername(staff.getStaffEmail());
        staff.setStaffPassword(passwordEncoder.encode("rootpassword"));
        return staffRepository.save(staff);
    }

    @Override
    public Staff findByStaffUsername(String staffUsername) {
        Optional<Staff> staff =  staffRepository.findByStaffUsername(staffUsername);
        if(staff.isPresent()){
            return staff.get();
        }
        return null;
    }

    

    @Override
    public boolean updateStaff(Staff staff) {
        
        if(isStaffExist(staff.getStaffId())) {
            String password = passwordEncoder.encode(staff.getStaffPassword());
            staff.setStaffPassword(password);
            staffRepository.updateStaff(staff.getStaffUsername(), password, staff.getStaffId());
            return true;
        }
            return false;
    }

    private boolean isStaffExist(int staffId) {
        Optional<Staff> staff = staffRepository.findById(staffId);
        System.out.println("Staff is present: " + staff.get());
        return staff.isPresent();
    }

    @Override
    public boolean deleteByStaffId(int staffId) {
        if (!isStaffExist(staffId)) {
            return false;
        }
        System.out.println("Deleting " + staffId);
        staffRepository.deleteById(staffId);
        return true;
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public int getStaffIdByStaffUsername(String username){
        return staffRepository.getStaffIdByStaffUsername(username);
    }
}