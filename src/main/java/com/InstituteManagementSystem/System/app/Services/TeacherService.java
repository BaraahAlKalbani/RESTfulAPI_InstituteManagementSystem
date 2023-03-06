package com.InstituteManagementSystem.System.app.Services;

import com.InstituteManagementSystem.System.app.Models.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
@Service
public class TeacherService {

    // The list of teachers
    public List<Teacher> listOfTeachers = new CopyOnWriteArrayList<>();
    // The current ID for new teachers
    int currId = 1;
    // Creates a Logger instance for the TeacherService class using the LoggerFactory.getLogger() method.
    private static final Logger logger = LoggerFactory.getLogger(TeacherService.class);

    /**
     * Returns all the teachers in the system
     * @return The list of all teachers
     */
    public List<Teacher> getAllTeachers() {
        return listOfTeachers;
    }

    /**
     * Gets the teacher with the specified ID
     * @param id The ID of the teacher to get
     * @return The teacher with the specified ID, or null if not found
     */
    public Teacher getTeacher(int id) {
        Optional<Teacher> foundRecord = listOfTeachers.stream().filter(
                (currentTeacher) -> {
                    return currentTeacher.id == id;
                }
        ).findFirst();
        if (foundRecord.isPresent()) {
            return foundRecord.get();
        } else {
            return null;
        }
    }

    /**
     * Creates a new teacher with the specified details
     * @param currTeacher The teacher to create
     * @return The created teacher
     */
    public Teacher createTeacher(Teacher currTeacher) {
        currTeacher.id = this.currId++;
        listOfTeachers.add(currTeacher);
        logger.info("Created Teacher with id: " + currTeacher.id);
        return currTeacher;
    }

    /**
     * Updates the teacher with the specified ID with the given details
     * @param id The ID of the teacher to update
     * @param upToDateTeacher The updated details of the teacher
     * @return The updated teacher
     */
    public Teacher updateTeacher(int id, Teacher upToDateTeacher) {
        Teacher foundTeacher = getTeacher(id);
        foundTeacher.name = upToDateTeacher.name;
        foundTeacher.email = upToDateTeacher.email;
        foundTeacher.salary = upToDateTeacher.salary;
        logger.info("Updated Teacher with id: " + id);
        return foundTeacher;
    }

    /**
     * Deletes the teacher with the specified ID
     * @param id The ID of the teacher to delete
     * @return The updated list of teachers after deletion
     */
    public List<Teacher> deleteTeacher(int id) {
        Teacher foundTeacher = getTeacher(id);
        listOfTeachers.remove(foundTeacher);
        logger.info("Deleted Teacher with id: " + id);
        return listOfTeachers;
    }
}
