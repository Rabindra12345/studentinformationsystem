package com.rabindra.studinfomgmt.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name="studentId")
    int studentId;

    @Column(name="courseId")
    int courseId;

    @Column(name="classDate")
    Date classDate;

    @Column(name="attendanceStatus")
    String attendanceStatus;
}
