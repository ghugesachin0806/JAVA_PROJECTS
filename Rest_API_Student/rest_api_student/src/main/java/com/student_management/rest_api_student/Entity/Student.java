package com.student_management.rest_api_student.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int rollno;
    private String name;

    // Unidirectional Mapping (Student---> Info)
    @OneToOne(cascade = CascadeType.ALL)
    private Info info;

    public Student() {
    }

    public Student(int id, int rollno, String name, Info info) {
        this.id = id;
        this.rollno = rollno;
        this.name = name;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", rollno=" + rollno + ", name=" + name + ", info=" + info + "]";
    }

}
