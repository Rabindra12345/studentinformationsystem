//package com.rabindra.studinfomgmt.service;
//
//import com.rabindra.studinfomgmt.entity.Student;
//import com.rabindra.studinfomgmt.repo.StudentRepository;
//
//import java.util.List;
//
//public class StudentServiceImpl {
//
//    private StudentRepository studentRepository;
//
//    public StudentServiceImpl(StudentRepository studentRepository) {
//
//        this.studentRepository = studentRepository;
//    }
//
//    public List<Student> getAllStudents() {
//
//        return studentRepository.getAllStudents();
//    }
//
//    public Student getStudentById(String studentId) {
//        return studentRepository.getStudentById(studentId);
//    }
//
//    public Student getStudentById(int studentId) {
//
//        return studentRepository.getStudentById(studentId);
//    }
//
//
//    public void addStudent(Student student) {
//
//        studentRepository.addStudent(student);
//    }
//
//    public void updateStudent(Student student) {
//
//        studentRepository.updateStudent(student);
//    }
//
//    public void deleteStudent(String studentId) {
//
//        studentRepository.deleteStudent(studentId);
//    }
//}
//}
