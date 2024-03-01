package com.example.CollegemanagementAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.CollegemanagementAPI.Model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    // Additional custom query methods can be defined here if needed
}
