package main.java.org.example.studentgrademanager.service.impl;

import main.java.org.example.studentgrademanager.dto.GradeJournal;
import main.java.org.example.studentgrademanager.dto.Student;


import main.java.org.example.studentgrademanager.service.StudentService;
import main.java.org.example.studentgrademanager.util.UserInputHelperUtil;
public class StudentServiceImpl implements StudentService {

    @Override
    public Student findStudentById(GradeJournal gradeJournal, int studentId) {
        for (Student student : gradeJournal.getStudentsList()) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void addNewStudent(GradeJournal gradeJournal) {

        System.out.println( "\n----Enter Details of the Student to add --------\n");

        System.out.print("Enter student ID: ");
        int studentId = UserInputHelperUtil.readInteger("Enter student ID: ");

        if (studentId <= 0) {
            System.out.println("\nStudent ID must be greater than 0.");
            return;
        }

        if (findStudentById(gradeJournal, studentId) != null) {
            System.out.println("\nA student with this ID already exists.");
            return;
        }

        System.out.print("Enter first name: ");
        String firstName = UserInputHelperUtil.readNonEmptyString();

        System.out.print("Enter last name: ");
        String lastName = UserInputHelperUtil.readNonEmptyString();

        Student student = new Student(studentId, firstName, lastName);

        gradeJournal.addStudentToList(student);

        System.out.println( "\nStudent " + firstName +" " + lastName + " with studentId "
                + studentId + " has been created " );
    }
}