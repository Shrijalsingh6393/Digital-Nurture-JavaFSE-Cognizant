package com.pattern.mvc;

public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    // Update model data
    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentId(String id) {
        model.setId(id);
    }

    public void setStudentGrade(double grade) {
        model.setGrade(grade);
    }

    // Retrieve model data
    public String getStudentName() {
        return model.getName();
    }

    public String getStudentId() {
        return model.getId();
    }

    public double getStudentGrade() {
        return model.getGrade();
    }

    // Update view
    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}
