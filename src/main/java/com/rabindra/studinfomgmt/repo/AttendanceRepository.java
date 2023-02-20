package com.rabindra.studinfomgmt.repo;


import com.rabindra.studinfomgmt.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {


}
