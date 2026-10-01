package main.java.org.example.studentgrademanager.service;

import main.java.org.example.studentgrademanager.dto.GradeJournal;
import main.java.org.example.studentgrademanager.dto.Student;


public interface StudentService {

    Student findStudentById(GradeJournal gradeJournal, int studentId);

    void addNewStudent(GradeJournal gradeJournal);
}
