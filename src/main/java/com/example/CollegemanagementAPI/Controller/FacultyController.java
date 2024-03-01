package com.example.CollegemanagementAPI.Controller;

import com.example.CollegemanagementAPI.Model.College;
import com.example.CollegemanagementAPI.Model.Faculty;
import com.example.CollegemanagementAPI.Service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    @Autowired
    public FacultyService facultyService;

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }

    @GetMapping("/college")
    public List<Faculty> getFacultiesByCollegeName(@RequestParam String collegeName) {
        return facultyService.getFacultiesByCollegeName(collegeName);
    }

    @GetMapping("/department")
    public List<Faculty> getFacultiesByDepartmentName(@RequestParam String departmentName) {
        return facultyService.getFacultiesByDepartmentName(departmentName);
    }

    @PutMapping("/{id}")
    public College updateCollege(@PathVariable Long id, @RequestBody Faculty faculty) {

        return facultyService.updateFaculty(id, faculty).getCollege();
    }

    @DeleteMapping("/{id}")
    public void deleteCollege(@PathVariable Long id) {
        FacultyService.deleteFaculty(id);
    }
}
