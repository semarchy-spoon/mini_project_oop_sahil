package main.java.org.example.studentgrademanager.service.impl;

import main.java.org.example.studentgrademanager.dto.GradeJournal;
import main.java.org.example.studentgrademanager.dto.Subject;
import main.java.org.example.studentgrademanager.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {

    @Override
    public Subject findSubjectById(GradeJournal gradeJournal, int subjectId) {
        for (Subject subject : gradeJournal.getSubjects()) {
            if (subject.getSubjectId() == subjectId) {
                return subject;
            }
        }
        return null;
    }
}