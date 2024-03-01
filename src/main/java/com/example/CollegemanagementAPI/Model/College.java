package com.example.CollegemanagementAPI.Model;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Data
@Table(name="college")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class College {
    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    public List<Department> departments;
    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    public List<Department> faculties;
    public College(String name) {
        this.name = name;
    }

}
