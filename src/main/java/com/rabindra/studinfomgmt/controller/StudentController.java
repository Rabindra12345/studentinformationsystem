package com.rabindra.studinfomgmt.controller;

import com.rabindra.studinfomgmt.entity.Attendance;
import com.rabindra.studinfomgmt.entity.Grade;
import com.rabindra.studinfomgmt.entity.Student;
import com.rabindra.studinfomgmt.entity.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.rabindra.studinfomgmt.exception.ResourceNotFoundException;
import com.rabindra.studinfomgmt.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentRequest) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setAddress(studentRequest.getAddress());
        student.setEnrollmentDate(studentRequest.getEnrollmentDate());
        student.setBirthdate(studentRequest.getBirthdate());

        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));


        studentRepository.delete(student);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        return student.getCourses();
    }

    @GetMapping("/{id}/attendance")
    public List<Attendance> getAttendanceByStudentId(@PathVariable Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        return student.getAttendances();
    }

    @GetMapping("/{id}/grades")
    public List<Grade> getGradesByStudentId(@PathVariable Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        return student.getGrades();
    }
}
