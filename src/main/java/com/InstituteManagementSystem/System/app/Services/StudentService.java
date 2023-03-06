package com.InstituteManagementSystem.System.app.Services;

import com.InstituteManagementSystem.System.app.Models.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class StudentService {
    public List<Student> listOfStudents= new CopyOnWriteArrayList<>();
    int currId=1;
    public List<Student> getAllStudents(){
        return listOfStudents;
    }
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
    public Student createStudent(Student currStudent){
        currStudent.id = this.currId++;
        listOfStudents.add(currStudent);
        return currStudent;
    }
    public Student updateStudent(int id,Student upToDateStudent){
        Student foundStudent = getStudent(id);
        foundStudent.name =upToDateStudent.name;
        foundStudent.email = upToDateStudent .email;
        return foundStudent;
    }
    public List<Student> deleteStudent(int id){
        Student foundStudent = getStudent(id);
        listOfStudents.remove(foundStudent);
        return listOfStudents;
    }

}
