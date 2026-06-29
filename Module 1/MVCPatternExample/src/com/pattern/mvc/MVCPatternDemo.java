package com.pattern.mvc;

public class MVCPatternDemo {
    public static void main(String[] args) {
        // Create Model
        Student student = new Student("Alice", "S1001", 92.5);
        // Create View
        StudentView view = new StudentView();
        // Create Controller
        StudentController controller = new StudentController(student, view);

        System.out.println("--- Initial Student Details (via Controller) ---");
        controller.updateView();

        // Update Model via Controller
        controller.setStudentName("Bob");
        controller.setStudentId("S1002");
        controller.setStudentGrade(88.0);

        System.out.println("\n--- Updated Student Details (via Controller) ---");
        controller.updateView();
    }
}
