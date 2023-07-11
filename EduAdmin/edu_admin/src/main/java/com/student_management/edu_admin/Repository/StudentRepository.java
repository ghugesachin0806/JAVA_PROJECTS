package com.student_management.edu_admin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student_management.edu_admin.Entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    
}
