package com.InstituteManagementSystem.System.app.Services;

import com.InstituteManagementSystem.System.app.Models.Course;
import com.InstituteManagementSystem.System.app.Models.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CourseService {
    // Thread-safe list of courses
    public List<Course> listOfCourses = new CopyOnWriteArrayList<>();
    // Counter for generating unique course IDs
    int currId = 1;
    // Creates a Logger instance for the CourseService class using the LoggerFactory.getLogger() method.
    private static final Logger logger = LoggerFactory.getLogger(CourseService.class);

    /**
     * Returns a list of all courses.
     * @return List of Course objects.
     */
    public List<Course> getAllCourses() {
        return listOfCourses;
    }

    /**
     * Returns a course with the specified ID.
     * @param id The ID of the course to retrieve.
     * @return The Course object with the specified ID, or null if no such course exists.
     */
    public Course getCourseById(int id) {
        Optional<Course> foundRecord = listOfCourses.stream().filter(
                (currentCourse) -> {
                    return currentCourse.id == id;
                }
        ).findFirst();
        if (foundRecord.isPresent()) {
            return foundRecord.get();
        } else return null;
    }

    /**
     * Creates a new course with the provided data.
     * @param currCourse The Course object containing the data for the new course.
     * @return The newly created Course object.
     */
    public Course addCourse(Course currCourse) {
        currCourse.id = this.currId++;
        listOfCourses.add(currCourse);
        logger.info("Created course with id: " + currCourse.id);
        return currCourse;
    }

    /**
     * Updates the data of an existing course.
     * @param id The ID of the course to update.
     * @param currCourse The updated Course object.
     * @return The updated Course object.
     */
    public Course updateCourse(int id, Course currCourse) {
        Optional<Course> foundRecord = listOfCourses.stream().filter(
                (currentCourse) -> {
                    return currentCourse.id == id;
                }
        ).findFirst();
        if (foundRecord.isPresent()) {
            int index = listOfCourses.indexOf(foundRecord.get());
            listOfCourses.set(index, currCourse);
            logger.info("Updated course with id: " + currCourse.id);
            return currCourse;
        } else return null;
    }

    /**
     * Deletes an existing course.
     * @param id The ID of the course to delete.
     * @return List of all courses after deleting the specified course.
     */
    public List<Course> deleteCourse(int id) {
        Optional<Course> foundRecord = listOfCourses.stream().filter(
                (currentCourse) -> {
                    return currentCourse.id == id;
                }
        ).findFirst();
        if (foundRecord.isPresent()) {
            listOfCourses.remove(foundRecord.get());
            logger.info("Deleted course with id: " + id);
        }
        return listOfCourses;
    }

    /**
     * Deletes a student from a course.
     * @param courseId The ID of the course to delete the student from.
     * @param studentId The ID of the student to delete.
     */
    public void deleteStudentById(int courseId, int studentId) {
        // Find the course with the given ID
        Course course = null;
        for (Course c : listOfCourses) {
            if (c.getId() == courseId) {
                course = c;
                break;
            }
        }
        if (course == null) {
            throw new IllegalArgumentException("Course not found with ID: " + courseId);
        }
        // Remove the student with the given ID from the course's student list
        List<Student> students = course.getStudents();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == studentId) {
                students.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Student not found with ID: " + studentId);
    }

    /**
     * Adds a student to a course.
     * @param courseId The ID of the course to add the student to.
     * @param student The student to add to the course.
     */
    public void addStudentToCourse(int courseId, Student student) {
        // Find the course with the given ID
        Course course = null;
        for (Course c : listOfCourses) {
            if (c.getId() == courseId) {
                course = c;
                break;
            }
        }
        if (course == null) {
            throw new IllegalArgumentException("Course not found with ID: " + courseId);
        }
        // Add the student to the course's student list
        List<Student> students = course.getStudents();
        students.add(student);
    }
}