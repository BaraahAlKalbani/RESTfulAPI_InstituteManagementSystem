package com.InstituteManagementSystem.System.app.Models;

import java.util.List;

public class Course {
    // The ID of the course.
    public int id;
    // The name of the course.
    public String name;
    // The teacher teaching the course.
    public Teacher teacher;
    // The list of students enrolled in the course.
    public List<Student> students;

    public Course(int id, String name, Teacher teacher, List<Student> students) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.students = students;
    }

    /**
     * Get the list of students enrolled in the course.
     * @return The list of students.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Get the ID of the course.
     * @return The ID of the course.
     */
    public int getId() {
        return id;
    }
}
