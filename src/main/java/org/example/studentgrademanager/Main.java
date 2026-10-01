package main.java.org.example.studentgrademanager;

import main.java.org.example.studentgrademanager.dto.GradeJournal;
import main.java.org.example.studentgrademanager.dto.Subject;
import main.java.org.example.studentgrademanager.service.GradeService;
import main.java.org.example.studentgrademanager.service.StudentService;
import main.java.org.example.studentgrademanager.service.SubjectService;
import main.java.org.example.studentgrademanager.service.impl.GradeServiceImpl;
import main.java.org.example.studentgrademanager.service.impl.StudentServiceImpl;
import main.java.org.example.studentgrademanager.service.impl.SubjectServiceImpl;
import main.java.org.example.studentgrademanager.util.UserInputHelperUtil;


public class Main {

    public static void main(String[] args) {

        StudentService studentServiceImpl = new StudentServiceImpl();

        SubjectService subjectServiceImpl = new SubjectServiceImpl();

        GradeService gradeServiceImpl = new GradeServiceImpl(studentServiceImpl, subjectServiceImpl);

        GradeJournal gradeJournal = new GradeJournal();

        fillSubjectsList(gradeJournal);

        int choice;

        do {
            UserInputHelperUtil.displayUserChoices();

            choice = UserInputHelperUtil.readInteger("Enter your choice");

            switch (choice) {
                case 1:
                    studentServiceImpl.addNewStudent(gradeJournal);
                    break;
                case 2:
                    gradeServiceImpl.recordGrade(gradeJournal);
                    break;
                case 3:
                    gradeServiceImpl.displayStudentAverageMark(gradeJournal);
                    break;
                case 4:
                    gradeServiceImpl.updateGrade(gradeJournal);
                    break;
                case 5:
                    gradeServiceImpl.removeGrade(gradeJournal);
                    break;
                case 6:
                    gradeServiceImpl.showTopScoringStudent(gradeJournal);
                    break;
                case 7:
                    gradeServiceImpl.showLastGradeEntered(gradeJournal);
                    break;
                case 8:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 8);
    }


    static void fillSubjectsList(GradeJournal gradeJournal) {

        gradeJournal.addSubjectToList(new Subject(1, "Java"));

        gradeJournal.addSubjectToList(new Subject(2, "Mathematics"));

        gradeJournal.addSubjectToList(new Subject(3, "English"));

        gradeJournal.addSubjectToList(new Subject(4, "Database"));
    }
}