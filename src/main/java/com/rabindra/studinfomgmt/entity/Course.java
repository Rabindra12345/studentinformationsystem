package com.rabindra.studinfomgmt.entity;


import java.util.List;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseCode ;


    @Column(name="name",nullable = false)
    private String courseName;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private List<Student> students;


    @Override
    public String toString() {
        return "Course{" +
                "courseCode=" + courseCode +
                ", courseName='" + courseName + '\'' +
                ", students=" + students +
                '}';
    }

    public Course(String courseName, List<Student> students) {
        this.courseName = courseName;
        this.students = students;
    }

    public Course(){

    }

}
