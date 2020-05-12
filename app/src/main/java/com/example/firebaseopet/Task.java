package com.example.firebaseopet;

public class Task {
    private String time;
    private String taskTitle;
    private String priority;
    private String category;

    public Task(String time, String taskTitle, String priority, String category) {
        this.time = time;
        this.taskTitle = taskTitle;
        this.priority = priority;
        this.category = category;
    }

    public Task() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
