package main.java.org.example.studentgrademanager.service;

import main.java.org.example.studentgrademanager.dto.GradeJournal;
import main.java.org.example.studentgrademanager.dto.Subject;

public interface SubjectService {

    Subject findSubjectById(GradeJournal gradeJournal, int subjectId);
}
