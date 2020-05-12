package com.example.firebaseopet;

public class Sales {
    private String title;
    private String description;
    private double dValue;

    public Sales(String title, String description, double dValue) {
        this.title = title;
        this.description = description;
        this.dValue = dValue;
    }

    public Sales() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getdValue() {
        return dValue;
    }

    public void setdValue(double dValue) {
        this.dValue = dValue;
    }
}
