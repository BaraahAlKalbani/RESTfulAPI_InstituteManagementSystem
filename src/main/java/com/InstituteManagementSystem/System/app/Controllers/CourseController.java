package com.InstituteManagementSystem.System.app.Controllers;

import com.InstituteManagementSystem.System.app.Models.Course;
import com.InstituteManagementSystem.System.app.Models.Student;
import com.InstituteManagementSystem.System.app.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing courses.
 */
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * Get a list of all courses.
     * @return List of all courses.
     */
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    /**
     * Get a course by its ID.
     * @param id The ID of the course to get.
     * @return The course with the specified ID.
     */
    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable(name = "courseId" ) int id) {
        return courseService.getCourseById(id);
    }

    /**
     * Add a new course.
     * @param course The course to add.
     */
    @PostMapping
    public void addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    /**
     * Update an existing course.
     * @param id The ID of the course to update.
     * @param course The updated course.
     */
    @PutMapping("/{courseId}")
    public void updateCourse(@PathVariable(name = "courseId" ) int id, @RequestBody Course course) {
        courseService.updateCourse(id, course);
    }

    /**
     * Delete a course by its ID.
     * @param id The ID of the course to delete.
     */
    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable(name = "courseId" ) int id) {
        courseService.deleteCourse(id);
    }

    /**
     * Add a student to a course.
     * @param courseId The ID of the course to add the student to.
     * @param student The student to add.
     */
    @PostMapping("/{courseId}/students")
    public void addStudentToCourse(@PathVariable(name = "courseId" ) int courseId, @RequestBody Student student) {
        courseService.addStudentToCourse(courseId, student);
    }

    /**
     * Delete a student from a course by their ID.
     * @param courseId The ID of the course.
     * @param studentId The ID of the student to delete.
     */
    @DeleteMapping("/{courseId}/students/{studentId}")
    public void deleteStudentById(@PathVariable(name = "courseId" ) int courseId, @PathVariable(name = "studentId" ) int studentId) {
        courseService.deleteStudentById(courseId, studentId);
    }
}