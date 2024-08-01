package camp.model;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private String studentId; // 수강생 고유번호
    private int scoreId = 0; // 회차 범위 1 ~ 10
    private String subjectType; // 과목(필수 / 선택)
    private int score; // 점수
    private char grade; // 등급

    List<Score> scores = new ArrayList<>();

    public Score(int seq, String subjectType, String studentId, int score, char grade) {
        this.scoreId = seq;
        this.subjectType = subjectType;
        this.studentId = studentId;
        this.score = score;
        this.grade = grade;
    }

    public Score(){}

    // Getter
    public int getScoreId() {
        return scoreId;
    }
    public String getSubjectType() { return subjectType; }
    public String getStudentId() { return studentId; }
    public int getScore() { return score; }
    public char getGrade() { return grade; }

    // Setter
    public void setScoreId(){
        this.scoreId = scoreId + 1;
    }

    public void setSubjectType(String subjectType){
        this.subjectType = subjectType;
    }

    public void setStudentId(String studentId){
        this.studentId = studentId;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void setGrade(char grade){
        this.grade = grade;
    }



    public void scoreRegist(Student student, int score){
        char grade = scoreToGrade(score, subjectType);
        student.getStudentId();

        //scores.add(new Score( seq, subjectType, studentId, score, scoreToGrade(score, subjectType)));
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