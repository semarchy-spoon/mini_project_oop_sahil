package main.java.org.example.studentgrademanager.service.impl;

import main.java.org.example.studentgrademanager.dto.Grade;
import main.java.org.example.studentgrademanager.dto.GradeJournal;
import main.java.org.example.studentgrademanager.dto.Student;
import main.java.org.example.studentgrademanager.dto.Subject;
import main.java.org.example.studentgrademanager.service.GradeService;
import main.java.org.example.studentgrademanager.service.StudentService;
import main.java.org.example.studentgrademanager.service.SubjectService;
import main.java.org.example.studentgrademanager.util.UserInputHelperUtil;

public class GradeServiceImpl implements GradeService {

    private StudentService studentService;

    private SubjectService subjectService;

    public GradeServiceImpl(StudentService studentService, SubjectService subjectService) {
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    @Override
    public Grade findGrade(GradeJournal gradeJournal, int studentId, int subjectId) {
        for (Grade grade : gradeJournal.getGradesList()) {
            if (grade.getStudent().getStudentId() == studentId &&
                    grade.getSubject().getSubjectId() == subjectId) {
                return grade;
            }
        }
        return null;
    }

    @Override
    public double getStudentAverage(GradeJournal gradeJournal, int studentId) {
        double totalMarks = 0;
        int numberOfGradesRecordedForStudent = 0;

        for (Grade grade : gradeJournal.getGradesList()) {
            if (grade.getStudent().getStudentId() == studentId) {
                totalMarks += grade.getMark();
                numberOfGradesRecordedForStudent++;
            }
        }

        if (numberOfGradesRecordedForStudent == 0) {
            return -1;
        }

        return totalMarks / numberOfGradesRecordedForStudent;
    }


    @Override
    public void recordGrade(GradeJournal gradeJournal) {

        gradeJournal.displayStudentsList();
        System.out.println( "--------------------\n-----Enter the studentId of the Student to record Grade -----");
        System.out.print("Enter student ID: ");
        int studentId = UserInputHelperUtil.readInteger("Enter student ID: ");

        Student student = studentService.findStudentById( gradeJournal, studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        gradeJournal.displaySubjectsList();
        System.out.println( "--------------------");
        System.out.print("Enter subject ID: ");
        int subjectId = UserInputHelperUtil.readInteger("Enter subject ID: ");

        Subject subject = subjectService.findSubjectById(gradeJournal, subjectId);

        if (subject == null) {
            System.out.println("Subject not found.");
            return;
        }

        Grade existingGrade = findGrade(gradeJournal, studentId, subjectId);

        if (existingGrade != null) {
            System.out.println("A grade already exists for this student and subject.");
            return;
        }

        System.out.print("Enter grade (0 - 100): ");
        int mark = UserInputHelperUtil.readInteger("Enter grade (0 - 100): ");

        if (mark < 0 || mark > 100) {
            System.out.println("Grade must be between 0 and 100.");
            return;
        }

        Grade grade = new Grade(student, subject, mark);

        gradeJournal.addGradeToList(grade);
        System.out.println( student.getStudentFirstName() + " " + student.getStudentLastName()
                + " has a new grade of " + mark + " marks in " + subject.getSubjectName() );

    }

    @Override
    public void displayStudentAverageMark(GradeJournal gradeJournal) {

        gradeJournal.displayStudentsList();
        System.out.println( "--------------------\n-----Enter the studentId of the Student to obtain his avaerage marks -----");


        System.out.print("Enter student ID: ");
        int studentId = UserInputHelperUtil.readInteger("Enter student ID: ");

        Student student = studentService.findStudentById(gradeJournal, studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        double average = getStudentAverage(gradeJournal, studentId);

        if (average == -1) {
            System.out.println("No grades recorded for this student.");
            return;
        }

        System.out.println("Average marks for " + student.getStudentFirstName() + " " +student.getStudentLastName() + " : " + average);

        if (average >= 40) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }


    @Override
    public void updateGrade(GradeJournal gradeJournal) {

        gradeJournal.displayStudentsList();
        System.out.println( "--------------------\n-----Enter the studentId of the Student to update Grade -----");

        System.out.print("Enter student ID: ");
        int studentId = UserInputHelperUtil.readInteger("Enter student ID: ");

        Student student = studentService.findStudentById( gradeJournal, studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        gradeJournal.displaySubjectsList();
        System.out.print("Enter subject ID: ");
        int subjectId = UserInputHelperUtil.readInteger("Enter subject ID: ");

        Subject subject = subjectService.findSubjectById(gradeJournal, subjectId);

        if (subject == null) {
            System.out.println("Subject not found.");
            return;
        }

        Grade grade = findGrade(gradeJournal, studentId, subjectId);

        if (grade == null) {
            System.out.println("Grade not found.");
            return;
        }

        System.out.print("Enter new grade (0 - 100): ");
        int newGrade = UserInputHelperUtil.readInteger("Enter new grade (0 - 100): ");

        if (newGrade < 0 || newGrade > 100) {
            System.out.println("Grade must be between 0 and 100.");
            return;
        }

        grade.setMark(newGrade);

        System.out.println( student.getStudentFirstName() + " " + student.getStudentLastName()
                + " has a new grade of " + newGrade + " marks in " + subject.getSubjectName() );

    }


    @Override
    public void removeGrade(GradeJournal gradeJournal) {

        gradeJournal.displayStudentsList();
        System.out.println( "--------------------\n-----Enter the studentId of the Student to remove Grade -----");

        System.out.print("Enter student ID: ");
        int studentId = UserInputHelperUtil.readInteger("Enter student ID: ");

        Student student = studentService.findStudentById( gradeJournal, studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        gradeJournal.displaySubjectsList();
        System.out.print("Enter subject ID: ");
        int subjectId = UserInputHelperUtil.readInteger("Enter subject ID: ");

        Subject subject = subjectService.findSubjectById(gradeJournal, subjectId);

        if (subject == null) {
            System.out.println("Subject not found.");
            return;
        }

        Grade grade = findGrade(gradeJournal, studentId, subjectId);

        if (grade == null) {
            System.out.println("Grade not found.");
            return;
        }



        System.out.println( "Grade of " + grade.getMark() + " marks for "
                + student.getStudentFirstName() + " " + student.getStudentLastName()
                  +" in " + subject.getSubjectName() + " as been removed" );

        gradeJournal.getGradesList().remove(grade);
    }


    @Override
    public void showTopScoringStudent(GradeJournal gradeJournal) {

        Student topStudent = null;
        double highestAverage = -1;

        for (Student student : gradeJournal.getStudentsList()) {
            double average = getStudentAverage(gradeJournal, student.getStudentId());
            if (average > highestAverage) {
                highestAverage = average;
                topStudent = student;
            }
        }

        if (topStudent == null) {
            System.out.println("No grades recorded.");
            return;
        }

        System.out.println(
                "Top Scoring Student: " + topStudent
        );

        System.out.println(
                "Average: " + highestAverage
        );
    }


    @Override
    public void showLastGradeEntered(GradeJournal gradeJournal) {
        if (gradeJournal.getGradesList().isEmpty()) {
            System.out.println("No grades recorded.");
            return;
        }

        int lastIndex = gradeJournal.getGradesList().size() - 1;

        Grade lastGrade = gradeJournal.getGradesList().get(lastIndex);

        System.out.println("Last Grade Entered:\nStudent: "
                + lastGrade.getStudent().getStudentFirstName()
                + " " + lastGrade.getStudent().getStudentLastName()
                + " Subject: " + lastGrade.getSubject().getSubjectName()
                + " Grade: " + lastGrade.getMark()
        );

    }
}