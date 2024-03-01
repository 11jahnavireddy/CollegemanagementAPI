package com.example.CollegemanagementAPI.Service;

import com.example.CollegemanagementAPI.Model.College;
import com.example.CollegemanagementAPI.Repository.CollegeRepository;
import com.example.CollegemanagementAPI.exception.CollegeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {
    private final CollegeRepository collegeRepository;

    @Autowired
    public CollegeService(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    public College addCollege(College college) {
        return collegeRepository.save(college);
    }




    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    public College updateCollege(Long id, College updatedCollege) {
        College existingCollege = getCollegeById(id);
        existingCollege.setName(updatedCollege.getName());
        // Set other attributes as needed
        return collegeRepository.save(existingCollege);
    }

    public void deleteCollege(Long id) {
        College existingCollege = getCollegeById(id);
        collegeRepository.delete(existingCollege);
    }
    public College findCollegeById(Long id) {
        Optional<College> collegeOptional = collegeRepository.findById(id);
        return collegeOptional.orElse(null);
    }
    public College getCollegeById(Long collegeId) {
        return collegeRepository.findById(collegeId)
                .orElseThrow(() -> new CollegeNotFoundException("College not found with ID: " + collegeId));
    }
}
