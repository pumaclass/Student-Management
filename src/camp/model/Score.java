package camp.model;

public class Score {
    private String studentId; // 수강생 고유번호
    private int scoreId = 0; // 회차 범위 1 ~ 10
    private String subjectName; // 과목(필수 / 선택)
    private int score; // 점수
    private char grade; // 등급

    public Score(Student student, int scoreId, Subject subject, int score) {
        this.scoreId = scoreId;
        this.subjectName = subject.getSubjectName();
        this.studentId = student.getStudentId();
        this.score = score;
        this.grade = scoreToGrade(score, subject.getSubjectType());
    }

    // Getter
    public int getScoreId() { return this.scoreId; }
    public String getSubjectName() { return this.subjectName; }
    public String getStudentId() { return this.studentId; }
    public int getScore() { return this.score; }
    public char getGrade() { return this.grade; }

    // Setter
    public void setScoreId(){
        this.scoreId = scoreId;
    }

    public void setSubjectName(String subjectName){
        this.subjectName = subjectName;
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