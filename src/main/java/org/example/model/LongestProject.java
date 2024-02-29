package org.example.model;

public class LongestProject {
    private int id;
    private int monthDiff;

    public LongestProject(int id, int monthDiff) {
        this.id = id;
        this.monthDiff = monthDiff;
    }

    public int getId() {
        return id;
    }

    public int getMonthDiff() {
        return monthDiff;
    }
}
