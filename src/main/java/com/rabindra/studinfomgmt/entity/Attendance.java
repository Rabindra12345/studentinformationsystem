package com.rabindra.studinfomgmt.entity;

//import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import lombok.Getter;
import java.util.List;

import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="attendance")
@Getter
//@Setter
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    @Column(name = "status")
    private Boolean present;

    @Column(name = "total")
    private int total;

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", present=" + present +
                ", total=" + total +
                '}';
    }

//    public Attendance(Student student, Course course, int present, int total) {
//        this.student = student;
//        this.course = course;
//        this.present = present;
//        this.total = total;
//    }
//
//    public Attendance(){
//
//    }

    ////////////////////////////////GENERATING SETTER METHODS


    public void setId(int id) {

        this.id = id;
    }

    public void setStudent(Student student) {

        this.student = student;
    }

    public void setCourse(Course course) {

        this.course = course;
    }


    //SETTING CUSTOM PRESENT METHOD
    public void setPresent(Boolean present) {
        this.present = present;
        recalculateTotal();
    }

    private void recalculateTotal() {
        List<Attendance> attendanceList = student.getAttendances();
        long totalPresentDays = attendanceList.stream()
                .filter(attendance -> attendance.getPresent())
                .count();
        total = (int) totalPresentDays;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
