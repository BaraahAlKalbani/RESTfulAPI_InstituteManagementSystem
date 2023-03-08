package com.InstituteManagementSystem.System.app.Models;

public class Student {
    // The unique identifier for this student.
    public int id;
    // The name of this student.
    public String name;
    // The email address of this student.
    public String email;

    /**
     * Get the unique identifier for this student.
     * @return The ID of the student.
     */
    public int getId() {
        return id;
    }
}
