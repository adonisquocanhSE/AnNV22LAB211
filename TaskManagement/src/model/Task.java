package model;

import java.util.Date;

public class Task {

    private int id;
    private int taskTypeId;
    private String requirementName;
    private Date date;
    private double from;
    private double to;
    private String assignee;
    private String reviewer;

    //constructor chua tham so
    public Task(int id, int taskTypeId, String requirementName,
            Date date, double from, double to,
            String assignee, String reviewer) {

        this.id = id;
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    // Getter
    public int getId() {
        return id;
    }

    public int getTaskTypeId() {
        return taskTypeId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public Date getDate() {
        return date;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getReviewer() {
        return reviewer;
    }
}
