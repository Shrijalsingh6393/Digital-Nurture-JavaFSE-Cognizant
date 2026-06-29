package com.company.task;

/**
 * Represents a task in the task management system.
 */
public class Task {
    private int taskId;
    private String taskName;
    private String status; // e.g., "Pending", "In Progress", "Done"

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{id=" + taskId + ", name='" + taskName + "', status='" + status + "'}";
    }
}
