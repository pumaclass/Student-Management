
package camp.model;

import java.util.ArrayList;
import java.util.List;

public class Score2 {
    private String studentId; // 수강생 고유번호
    private int scoreId = 0; // 회차 범위 1 ~ 10
    private String subjectName; // 과목(필수 / 선택)
    private List<Integer> scores = new ArrayList<>(); // 점수
    private List<Character> grades = new ArrayList<>(); // 등급

    public Score2(Student student, int scoreId, Subject subject, int score) {
        this.scoreId = scoreId + 1;
        this.subjectName = subject.getSubjectName();
        this.studentId = student.getStudentId();
        this.scores.add(score);
        this.grades.add(scoreToGrade(score, subject.getSubjectType()));
    }

    // Getter
    public int getScoreId() { return this.scoreId; }
    public String getSubjectName() { return this.subjectName; }
    public String getStudentId() { return this.studentId; }
    public List<Integer> getScore() { return this.scores; }
    public List<Character> getGrade() { return this.grades; }

    // Setter
    public void setScoreId(int scoreId){
        this.scoreId = scoreId;
    }

    public void setScore(int score, int scoreId){
        this.scores.add(score);
    }

    public void setGrade(char grade, int scoreId){
        this.grades.add(grade);
    }

    public void addScore(int scoreId, int score, String subjectType){
        setScoreId(scoreId + 1);
        setScore(score, getScoreId() - 1); // scoreId는 등록된 점수 갯수를 의미, 인덱스는 갯수 - 1
        setGrade(scoreToGrade(score, subjectType), getScoreId() - 1);
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
