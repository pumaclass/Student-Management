package camp.model;

public class Score {
    private String scoreId;
    private double[] score = new double[10];

    public Score(String seq) {
        this.scoreId = seq;
    }

    // Getter
    public String getScoreId() {
        return scoreId;
    }

}