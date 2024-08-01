package camp.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String studentId;
    private final String studentName;
    private List<Subject> mainSubjects = new ArrayList<Subject>();
    private List<Subject> subSubjects = new ArrayList<Subject>();


    public Student(String studentId, String studentName, List<Subject> mainSubjects, List<Subject> subSubjects) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.mainSubjects = mainSubjects;
        this.subSubjects = subSubjects;
    }


    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void studentRegistration() {

    }

}
