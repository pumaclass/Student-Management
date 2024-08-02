package camp.model;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private final String subjectId;
    private String subjectName;
    private String subjectType;
    private Score scores;

    public Subject(String seq, String subjectName, String subjectType) {
        this.subjectId = seq;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
        this.scores = new Score();
    }

    // Getter
    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void printScores() {
        for (int i = 0; i < scores.getScore().size(); i++) {
            System.out.println(subjectName + " " + ( i + 1 ) + "회차: " + scores.getScore().get(i));
        }
    }

    public void printGrads() {
        for (char grade : scores.getGrade()) {
            System.out.println(subjectName + " " + grade);
        }
    }

    public void addScore(int score) {
        if(scores.getScore().size() < 10) {
            scores.setScore(score, subjectType);
        }
    }

    public void printAllGrades(){
        for (int i = 0; i < scores.getGrade().size(); i++) {
            System.out.println(subjectName + " " + ( i + 1 ) + "회차: " + scores.getGrade().get(i));
        }
    }

    public void printSubject() {
        System.out.println(subjectName);
    }

    public void editScores(int round, int newScore) {
        scores.editScore(round, newScore);
    }

}
