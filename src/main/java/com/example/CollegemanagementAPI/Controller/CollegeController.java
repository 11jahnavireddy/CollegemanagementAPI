package com.example.CollegemanagementAPI.Controller;

import com.example.CollegemanagementAPI.Model.College;
import com.example.CollegemanagementAPI.Repository.CollegeRepository;
import com.example.CollegemanagementAPI.Service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colleges")
public class CollegeController {
    private final CollegeService collegeService;



    @Autowired
    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @PostMapping
    public College addCollege(@RequestBody College college) {
        return collegeService.addCollege(college);
    }




    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    @PutMapping("/{id}")
    public College updateCollege(@PathVariable Long id, @RequestBody College college) {
        return collegeService.updateCollege(id, college);
    }

    @DeleteMapping("/{id}")
    public void deleteCollege(@PathVariable Long id) {
        collegeService.deleteCollege(id);
    }

    private CollegeRepository collegeRepository; // Assuming you have a CollegeRepository for database operations

    @GetMapping("/colleges/{id}")
    public ResponseEntity<?> getCollegeById(@PathVariable Long id) {
        College college = collegeRepository.findById(id).orElse(null);
        if (college == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("College with id " + id + " not found");
        }
        return ResponseEntity.ok(college);
    }
}
