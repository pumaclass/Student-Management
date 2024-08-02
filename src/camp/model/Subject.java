package camp.model;

public class Subject {
    private String subjectId;
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
        return this.subjectId;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public Score getScores(){
        return this.scores;
    }

    public String getSubjectType() {
        return this.subjectType;
    }

    public void setScore(int score){
        getScores().setScore(score, getSubjectType());
    }
}
