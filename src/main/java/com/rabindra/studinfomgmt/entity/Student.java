package com.rabindra.studinfomgmt.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Entity
@Getter
//@Setter
@Data
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;


    @Column(name="last_name")
    private String lastName;


    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name="birthdate")
    private Date birthdate;

    @Column(name="enrollmentDate")
    private Date enrollmentDate;
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    @Column(name = "total_attendance", nullable = false)
    private int totalAttendance;

    @OneToMany(mappedBy = "student")
    private List<Grade> grades;

    @OneToMany(mappedBy = "student")
    private List<Attendance> attendances;

    /////////////////////////////////////////


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", birthdate=" + birthdate +
                ", enrollmentDate=" + enrollmentDate +
                ", courses=" + courses +
                ", totalAttendance=" + totalAttendance +
                ", grades=" + grades +
                ", attendances=" + attendances +
                '}';
    }
}
