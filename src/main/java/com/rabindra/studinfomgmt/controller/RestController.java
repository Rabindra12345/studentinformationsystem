package com.rabindra.studinfomgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Attendance> attendances = attendanceService.getAttendancesByStudentId(id);
        List<Grade> grades = gradeService.getGradesByStudentId(id);
        List<Course> courses = new ArrayList<>();
        for (Attendance attendance : attendances) {
            courses.add(courseService.getCourseById(attendance.getCourseId()));
        }
        for (Grade grade : grades) {
            courses.add(courseService.getCourseById(grade.getCourseId()));
        }
        student.setAttendances(attendances);
        student.setGrades(grades);
        student.setCourses(courses);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        student.setId(id);
        studentService.updateStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

