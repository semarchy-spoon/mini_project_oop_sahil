package main.java.org.example.studentgrademanager.dto;

import java.util.ArrayList;
import java.util.List;

public class GradeJournal {

    private List<Student> students;

    private List<Subject> subjects;

    private List<Grade> grades;

    public GradeJournal() {
        this.students = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public void addStudentToList(Student student) {
        students.add(student);
    }

    public void addSubjectToList(Subject subject) {
        subjects.add(subject);
    }

    public void addGradeToList(Grade grade) {
        grades.add(grade);
    }

    public List<Grade> getGradesList() {
        return grades;
    }

    public List<Student> getStudentsList() {
        return students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void displayStudentsList() {
        System.out.println("-----Student List ----");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void displaySubjectsList() {
        System.out.println("-----Subject List ----");
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
    }
}