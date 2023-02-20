package com.rabindra.studinfomgmt.repo;

import com.rabindra.studinfomgmt.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByCourseCode(Long id);
}
