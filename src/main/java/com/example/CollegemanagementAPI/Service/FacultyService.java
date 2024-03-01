package com.example.CollegemanagementAPI.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CollegemanagementAPI.Repository.FacultyRepository;
import com.example.CollegemanagementAPI.Model.Faculty;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    public Faculty findFacultyById(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Faculty with id " + id + " not found"));
    }

    public static void deleteFaculty(Long id) {
    }

    public Faculty addFaculty(Faculty faculty) {
        return faculty;
    }

    public List<Faculty> getFacultiesByCollegeName(String collegeName) {
        return null;
    }

    public List<Faculty> getFacultiesByDepartmentName(String departmentName) {
        return null;
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        return faculty;
    }

    // Your service methods can use facultyRepository here
}
