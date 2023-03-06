package com.InstituteManagementSystem.System.app.Controllers;

import com.InstituteManagementSystem.System.app.Models.Student;
import com.InstituteManagementSystem.System.app.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * Retrieves all students.
     * @return List of all students.
     */
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    /**
     * Retrieves a specific student by ID.
     * @param id The ID of the student to retrieve.
     * @return The student with the specified ID.
     */
    @GetMapping(path = "/{id}")
    public Student getStudent(@PathVariable(name = "id" ) int id) {
        return studentService.getStudent(id);
    }

    /**
     * Creates a new student.
     * @param newStudent The student object to create.
     * @return The newly created student object.
     */
    @PostMapping
    public Student createStudent(@RequestBody Student newStudent) {
        studentService.createStudent(newStudent);
        return newStudent;
    }

    /**
     * Updates an existing student.
     * @param id The ID of the student to update.
     * @param currStudent The updated student object.
     * @return The updated student object.
     */
    @PutMapping(path = "/{id}")
    public Student UpdateStudent(@PathVariable(name = "id" )int id,@RequestBody Student currStudent) {
        studentService.updateStudent(id,currStudent);
        return currStudent;
    }

    /**
     * Deletes an existing student.
     * @param id The ID of the student to delete.
     * @return List of all students after deleting the specified student.
     */
    @DeleteMapping(path = "/{id}")
    public List<Student> deleteStudent(@PathVariable(name = "id" )int id) {
        return studentService.deleteStudent(id);
    }
}
