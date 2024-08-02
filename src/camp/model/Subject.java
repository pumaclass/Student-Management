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
    public String   getSubjectId()      { return this.subjectId; }
    public String   getSubjectName()    { return this.subjectName; }
    public Score    getScores()         { return this.scores; }
    public String   getSubjectType()    { return this.subjectType; }

    public void printScores() {
        for (Integer score : scores.getScore()) {
            System.out.println(subjectName + " " + score);
        };
    }

    public void addScore(int score) {
        if(scores.getScore().size() < 10) {
            getScores().setScore(score, subjectType);
        }
    }

    public void printSubject(int cnt) {
        System.out.println(cnt + ". " + subjectName);
    }
}
