package com.student_management.rest_api_student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student_management.rest_api_student.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Student findById(int id);
}
