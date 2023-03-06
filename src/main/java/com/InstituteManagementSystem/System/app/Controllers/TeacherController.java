package com.InstituteManagementSystem.System.app.Controllers;

import com.InstituteManagementSystem.System.app.Models.Teacher;
import com.InstituteManagementSystem.System.app.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping
    public List<Teacher> getTeachers()
    {
        return teacherService.getAllTeachers();
    }
    @GetMapping(path = "/{id}")
    public Teacher getTeacher(@PathVariable(name = "id" ) int id)
    {
        return teacherService.getTeacher(id);
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher newTeacher)
    {
        teacherService.createTeacher(newTeacher);
        return newTeacher;
    }
    @PutMapping(path = "/{id}")
    public Teacher UpdateTeacher(@PathVariable(name = "id" )int id,@RequestBody Teacher currTeacher)
    {
        teacherService.updateTeacher(id,currTeacher);
        return currTeacher;
    }
    @DeleteMapping(path = "/{id}")
    public List<Teacher> deleteTeacher(@PathVariable(name = "id" )int id)
    {
        return teacherService.deleteTeacher(id);
    }
}
