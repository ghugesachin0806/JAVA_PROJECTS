package com.student_management.rest_api_student.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student_management.rest_api_student.Services.StudentService;
import com.student_management.rest_api_student.Entity.Student;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Get All students
    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudents() {

        List<Student> list = this.studentService.getAllStudents();

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(list));
    }

    // Get single Student
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
        Student student = this.studentService.getStudent(id);

        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(student));

    }

    // Create/Add Student
    @PostMapping("/student")
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
        try {

            this.studentService.addStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete All students
    @DeleteMapping("/student")
    public ResponseEntity<Void> deleteAllStudents() {
        try {

            this.studentService.deleteAllStudents();
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();

        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    // Delete student
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id) {
        try {

            this.studentService.deleteStudent(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();

        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    // Update student
    @PutMapping("/student/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        try {
            this.studentService.updateStudent(student, id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();

        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

}
