package com.rabindra.studinfomgmt.controller;

import com.rabindra.studinfomgmt.entity.Grade;
import com.rabindra.studinfomgmt.exception.ResourceNotFoundException;
import com.rabindra.studinfomgmt.repo.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grades")
public class GradesController {

        @Autowired
        private GradeRepository gradeRepository;

        @GetMapping("/{id}")
        public Grade getGradeById(@PathVariable Long id) {
            return gradeRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Grade", "id", id));
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Grade createGrade(@RequestBody Grade grade) {
            return gradeRepository.save(grade);
        }

        @PutMapping("/{id}")
        public Grade updateGrade(@PathVariable Long id, @RequestBody Grade gradeRequest) {
            Grade grade = gradeRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Grade", "id", id));

            grade.setStudent(gradeRequest.getStudent());
            grade.setCourse(gradeRequest.getCourse());
            grade.setGrade(gradeRequest.getGrade());

            return gradeRepository.save(grade);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteGrade(@PathVariable Long id) {
            Grade grade = gradeRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Grade", "id", id));

            gradeRepository.delete(grade);

            return ResponseEntity.ok().build();
        }
    }


