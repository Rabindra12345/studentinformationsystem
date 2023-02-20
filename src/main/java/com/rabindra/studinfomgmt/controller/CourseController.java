package com.rabindra.studinfomgmt.controller;

import com.rabindra.studinfomgmt.entity.Attendance;
import com.rabindra.studinfomgmt.entity.Course;
import com.rabindra.studinfomgmt.exception.ResourceNotFoundException;
import com.rabindra.studinfomgmt.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody Course course) {

        return courseRepository.save(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course courseRequest) {
        Course course = courseRepository.findByCourseCode(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));

        course.setCourseCode(courseRequest.getCourseCode());
//        course.setDescription(courseRequest.getDescription());

        return courseRepository.save(course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));

        courseRepository.delete(course);

        return ResponseEntity.ok().build();
    }
}

