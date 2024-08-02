package camp.model;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private List<Integer> scores = new ArrayList<>(); // 점수
    private List<Character> grades = new ArrayList<>(); // 등급

    public Score() {}

    // Getter
    public List<Integer> getScore() { return this.scores; }
    public List<Character> getGrade() { return this.grades; }

    // Setter
    public void setScore(int score, String subjectType){
        this.grades.add(scoreToGrade(score, subjectType));
        this.scores.add(score);
    }

    public char scoreToGrade(int score, String subjectType){
        char grade = ' '; // 초기화

        switch(subjectType){
            case "MANDATORY":
                if(score >= 95) grade = 'A';
                else if(score >= 90) grade = 'B';
                else if(score >= 80) grade = 'C';
                else if(score >= 70) grade = 'D';
                else if(score >= 60) grade = 'F';
                else grade = 'N';
                break;

            case "CHOICE":
                if(score >= 90) grade = 'A';
                else if(score >= 80) grade = 'B';
                else if(score >= 70) grade = 'C';
                else if(score >= 60) grade = 'D';
                else if(score >= 50) grade = 'F';
                else grade = 'N';
                break;

            default:
                System.out.println("과목 타입 오류");
        }

        return grade;
    }
}