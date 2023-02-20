//package com.rabindra.studinfomgmt.repo;
//
//import com.rabindra.studinfomgmt.entity.Attendance;
//import com.rabindra.studinfomgmt.entity.Grade;
//import com.rabindra.studinfomgmt.entity.Student;
//
//import javax.persistence.Query;
//import java.util.List;
//
//public class StudentRepositoryImpl implements StudentRepository {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    @Transactional
//    public void addStudent(Student student) {
//        entityManager.persist(student);
//    }
//
//    @Override
//    @Transactional
//    public void updateStudent(Student student) {
//        entityManager.merge(student);
//    }
//
//    @Override
//    @Transactional
//    public void deleteStudent(Student student) {
//        entityManager.remove(entityManager.contains(student) ? student : entityManager.merge(student));
//    }
//
//    @Override
//    public Student getStudentById(String studentId) {
//        return entityManager.find(Student.class, studentId);
//    }
//
//    @Override
//    public List<Student> getAllStudents() {
//        Query query = entityManager.createQuery("SELECT s FROM Student s");
//        return query.getResultList();
//    }
//
//    @Override
//    public List<Student> getStudentsByCourse(String courseCode) {
//        Query query = entityManager.createQuery("SELECT s FROM Student s JOIN s.courses c WHERE c.courseCode = :courseCode");
//        query.setParameter("courseCode", courseCode);
//        return query.getResultList();
//    }
//
//    @Override
//    public List<Attendance> getAttendanceByStudentAndCourse(String studentId, String courseCode) {
//        Query query = entityManager.createQuery("SELECT a FROM Attendance a WHERE a.student.studentId = :studentId AND a.course.courseCode = :courseCode");
//        query.setParameter("studentId", studentId);
//        query.setParameter("courseCode", courseCode);
//        return query.getResultList();
//    }
//
//    @Override
//    public List<Grade> getGradesByStudentAndCourse(String studentId, String courseCode) {
//        Query query = entityManager.createQuery("SELECT g FROM Grade g WHERE g.student.studentId = :studentId AND g.course.courseCode = :courseCode");
//        query.setParameter("studentId", studentId);
//        query.setParameter("courseCode", courseCode);
//        return query.getResultList();
//    }
//}
