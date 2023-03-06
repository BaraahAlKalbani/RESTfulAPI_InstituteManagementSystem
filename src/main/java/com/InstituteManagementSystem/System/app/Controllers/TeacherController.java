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

    /**
     * Get all the teachers
     * @return List of all the teachers
     */
    @GetMapping
    public List<Teacher> getTeachers()
    {
        return teacherService.getAllTeachers();
    }

    /**
     * Get a teacher by id
     * @param id Id of the teacher to retrieve
     * @return The teacher with the specified id
     */
    @GetMapping(path = "/{id}")
    public Teacher getTeacher(@PathVariable(name = "id" ) int id)
    {
        return teacherService.getTeacher(id);
    }

    /**
     * Create a new teacher
     * @param newTeacher The teacher object to create
     * @return The created teacher object
     */
    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher newTeacher)
    {
        teacherService.createTeacher(newTeacher);
        return newTeacher;
    }

    /**
     * Update an existing teacher
     * @param id Id of the teacher to update
     * @param currTeacher The teacher object to update
     * @return The updated teacher object
     */
    @PutMapping(path = "/{id}")
    public Teacher UpdateTeacher(@PathVariable(name = "id" )int id,@RequestBody Teacher currTeacher)
    {
        teacherService.updateTeacher(id,currTeacher);
        return currTeacher;
    }

    /**
     * Delete a teacher by id
     * @param id Id of the teacher to delete
     * @return List of all the teachers after the deletion
     */
    @DeleteMapping(path = "/{id}")
    public List<Teacher> deleteTeacher(@PathVariable(name = "id" )int id)
    {
        return teacherService.deleteTeacher(id);
    }
}
