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
    @GetMapping
    public List<Student> getStudents()
    {
        return studentService.getAllStudents();
    }
    @GetMapping(path = "/{id}")
    public Student getStudent(@PathVariable(name = "id" ) int id)
    {
        return studentService.getStudent(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student newStudent)
    {
        studentService.createStudent(newStudent);
        return newStudent;
    }
    @PutMapping(path = "/{id}")
    public Student UpdateStudent(@PathVariable(name = "id" )int id,@RequestBody Student currStudent)
    {
        studentService.updateStudent(id,currStudent);
        return currStudent;
    }
    @DeleteMapping(path = "/{id}")
    public List<Student> deleteStudent(@PathVariable(name = "id" )int id)
    {
        return studentService.deleteStudent(id);
    }
}
