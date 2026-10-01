package main.java.org.example.studentgrademanager.service;

import main.java.org.example.studentgrademanager.dto.Grade;
import main.java.org.example.studentgrademanager.dto.GradeJournal;

public interface GradeService {

    Grade findGrade(GradeJournal gradeJournal, int studentId, int subjectId);

    double getStudentAverage(GradeJournal gradeJournal, int studentId);

    void recordGrade(GradeJournal gradeJournal);

    void displayStudentAverageMark(GradeJournal gradeJournal);

    void updateGrade(GradeJournal gradeJournal);

    void removeGrade(GradeJournal gradeJournal);

    void showTopScoringStudent(GradeJournal gradeJournal);

    void showLastGradeEntered(GradeJournal gradeJournal);
}
