package com.rabindra.studinfomgmt.repo;

import com.rabindra.studinfomgmt.entity.Attendance;
import com.rabindra.studinfomgmt.entity.Grade;
import com.rabindra.studinfomgmt.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;


public interface StudentRepository extends JpaRepository<Student, String> {
    Optional<Student> findById(Long id);

}
