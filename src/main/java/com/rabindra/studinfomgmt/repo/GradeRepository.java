package com.rabindra.studinfomgmt.repo;

import com.rabindra.studinfomgmt.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade,Long> {
}
