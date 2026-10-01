package main.java.org.example.studentgrademanager.dto;

public class Grade {

    private Student student;

    private Subject subject;

    private int mark;

    public Grade(Student student, Subject subject, int mark) {
        this.student = student;
        this.subject = subject;
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return student.getStudentFirstName() + " " + student.getStudentLastName() + "has " + mark + " marks in " + subject.getSubjectName() ;
    }
}