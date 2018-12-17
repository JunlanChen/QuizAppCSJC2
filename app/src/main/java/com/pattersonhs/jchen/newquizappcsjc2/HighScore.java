package com.pattersonhs.jchen.newquizappcsjc2;

public class HighScore {
    String name;
    int score;
    int rank;

    public HighScore(String newName, int newScore,int newRank){
        name = newName;
        score = newScore;
        rank = newRank;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getRank() {
        return rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
