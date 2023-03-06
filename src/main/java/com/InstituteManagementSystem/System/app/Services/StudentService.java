package com.InstituteManagementSystem.System.app.Services;

import com.InstituteManagementSystem.System.app.Models.Student;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Service class that provides operations for managing students.
 */
@Service
public class StudentService {

    // Thread-safe list of students
    public List<Student> listOfStudents= new CopyOnWriteArrayList<>();
    // Counter for generating unique student IDs
    int currId=1;
    // Creates a Logger instance for the StudentService class using the LoggerFactory.getLogger() method.
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    /**
     * Returns a list of all students.
     * @return List of Student objects.
     */
    public List<Student> getAllStudents(){
        return listOfStudents;
    }

    /**
     * Returns a student with the specified ID.
     * @param id The ID of the student to retrieve.
     * @return The Student object with the specified ID, or null if no such student exists.
     */
    public Student getStudent(int id)
    {
        Optional<Student> foundRecord = listOfStudents.stream().filter(
                (currentStudent) -> {
                    return currentStudent.id == id;
                }
        ).findFirst();
        if (foundRecord.isPresent())
        {
            return foundRecord.get();
        }
        else return null;
    }

    /**
     * Creates a new student with the provided data.
     * @param currStudent The Student object containing the data for the new student.
     * @return The newly created Student object.
     */
    public Student createStudent(Student currStudent){
        currStudent.id = this.currId++;
        listOfStudents.add(currStudent);
        logger.info("Created student with id: " + currStudent.id);
        return currStudent;
    }

    /**
     * Updates the data of an existing student.
     * @param id The ID of the student to update.
     * @param upToDateStudent The Student object containing the updated data.
     * @return The updated Student object.
     */
    public Student updateStudent(int id,Student upToDateStudent){
        Student foundStudent = getStudent(id);
        foundStudent.name =upToDateStudent.name;
        foundStudent.email = upToDateStudent .email;
        logger.info("Updated student with id: " + id);
        return foundStudent;
    }

    /**
     * Deletes a student with the specified ID.
     * @param id The ID of the student to delete.
     * @return The updated list of remaining students.
     */
    public List<Student> deleteStudent(int id){
        Student foundStudent = getStudent(id);
        listOfStudents.remove(foundStudent);
        logger.info("Deleted student with id: " + id);
        return listOfStudents;
    }
}
