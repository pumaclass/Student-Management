package camp.model;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private List<Integer> score; // 점수
    private List<Character> grade; // 등급

    public Score() {
        this.score = new ArrayList<Integer>();
        this.grade = new ArrayList<Character>();
    }

    public void setScore(int score, String subjectType) {
        this.grade.add(scoreToGrade(score, subjectType));
        this.score.add(score);
    }

    public List<Integer> getScore() {
        return score;
    }

    public List<Character> getGrade() {
        return grade;
    }

    public char scoreToGrade(int score, String subjectType){
        char grade = 'N'; // 초기화

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