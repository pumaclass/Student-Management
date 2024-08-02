package camp.model;

import java.util.ArrayList;
import java.util.List;


public class Student { //수강생
    private final String studentId;//고유번호(겹치는안되는 단위의 값)
    private String studentName;//이름
    private final List<Subject> mainSubjects; //과목목록-필수과목
    private final List<Subject> subSubjects; //과목목록-선택과목
    //리스트를 받기 때문에 목록을 갯수를 제한하지 않고 추가가능


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

    public List<Subject> getMainSubjects() {
        return mainSubjects;
    }

    public List<Subject> getSubSubjects() {
        return subSubjects;
    }

    //원하는 과목 하나만 출력
    public void printScores(String subjectName) {
        for (int i = 0; i < mainSubjects.size(); i++) {
            if (mainSubjects.get(i).getSubjectName().equals(subjectName) ) {
                mainSubjects.get(i).printScores();
            }
        }
        for (int i = 0; i < subSubjects.size(); i++) {
            if (subSubjects.get(i).getSubjectName().equals(subjectName) ) {
                subSubjects.get(i).printScores();
            }
        }
    }

    //모든 과목 출력
    public void printAllScores() {
        for (int i = 0; i < mainSubjects.size(); i++) {
            mainSubjects.get(i).printScores();
        }
        for (int i = 0; i < subSubjects.size(); i++) {
            subSubjects.get(i).printScores();
        }
    }

    public void addStudentScore(String subjectName, int score) {
        for (int i = 0; i < mainSubjects.size(); i++) {
            if (mainSubjects.get(i).getSubjectName().equals(subjectName) ) {
                mainSubjects.get(i).addScore(score);
            }
        }
        for (int i = 0; i < subSubjects.size(); i++) {
            if (subSubjects.get(i).getSubjectName().equals(subjectName) ) {
                subSubjects.get(i).addScore(score);
            }
        }
    }

    public void printAllSubject(){
        for (Subject mainSubject : mainSubjects) {
            mainSubject.printSubject();
        }
        for (Subject subSubject : subSubjects) {
            subSubject.printSubject();
        }
    }

    public void printAllGrades(){
        for (Subject mainSubject : mainSubjects) {
            mainSubject.printAllGrades();
        }
        for (Subject subSubject : subSubjects) {
            subSubject.printAllGrades();
        }
    }


    // Setter
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}
