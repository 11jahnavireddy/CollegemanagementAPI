package com.example.CollegemanagementAPI.Repository;

import com.example.CollegemanagementAPI.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByCollegeName(String collegeName);
}
