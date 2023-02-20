package com.rabindra.studinfomgmt.controller;

import com.rabindra.studinfomgmt.entity.Attendance;
import com.rabindra.studinfomgmt.entity.Course;
import com.rabindra.studinfomgmt.entity.Student;
import com.rabindra.studinfomgmt.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rabindra.studinfomgmt.repo.AttendanceRepository;


@RestController
@RequestMapping("/attendances")
public class AttendanceController {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @GetMapping("/{id}")
    public Attendance getAttendanceById(@PathVariable Long id) {
        return attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance", "id", id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable Long id, @RequestBody Attendance attendanceRequest) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance", "id", id));


        attendance.setPresent(attendanceRequest.getPresent());

        // Update the total field based on the present field of the attendance object
        Student student = attendance.getStudent();
        Course course = attendance.getCourse();
        int totalAttendance = student.getAttendances()
                .stream()
                .filter(a -> a.getCourse().equals(course))
                .mapToInt(a -> a.getPresent() ? 1 : 0)
                .sum();
        student.setTotalAttendance(totalAttendance);
        return attendanceRepository.save(attendance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAttendance(@PathVariable Long id) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance", "id", id));

        attendanceRepository.delete(attendance);

        return ResponseEntity.ok().build();
    }
}
