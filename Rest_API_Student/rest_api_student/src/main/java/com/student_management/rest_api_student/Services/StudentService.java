package com.student_management.rest_api_student.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.student_management.rest_api_student.Repository.StudentRepository;
import com.student_management.rest_api_student.Entity.Student;

@Component
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Get single Student
    public Student getStudent(int id) {

        Student student = null;

        try {
            student = this.studentRepository.findById(id);
            return student;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    // Get All students
    public List<Student> getAllStudents() {
        List<Student> list = this.studentRepository.findAll();
        return list;
    }

    // Create/Add Student
    public void addStudent(Student student) {

        this.studentRepository.save(student);
    }

    // Delete student
    public void deleteStudent(int id) {

        this.studentRepository.deleteById(id);
    }

    // Delete All students
    public void deleteAllStudents() {

        this.studentRepository.deleteAll();
    }

    // Update student
    public void updateStudent(Student student, int studentid) {

        this.studentRepository.save(student);
    }

}