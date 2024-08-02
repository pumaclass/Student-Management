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
        for (Integer score : scores.getScore()) {
            System.out.println(subjectName + " " + score);
        };
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
        for (Character grade : scores.getGrade()) {
            System.out.println(subjectName + " " + grade);
        }
    }

    public void printSubject() {
        System.out.println(subjectName);
    }

}
