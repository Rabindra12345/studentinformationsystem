package com.rabindra.studinfomgmt.entity;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name="name")
    String name;

    @Column(name = "email")
    String email;

    @Column(name = "address")
    String address;

    @Column(name="birthdate")
    Date birthdate;

    @Column(name="enrollmentDate")
    Date enrollmentDate;
    List<Attendance> attendances;
    List<Grade> grades;

}
