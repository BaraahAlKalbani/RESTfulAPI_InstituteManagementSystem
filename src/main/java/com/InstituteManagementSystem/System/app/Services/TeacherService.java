package com.InstituteManagementSystem.System.app.Services;

import com.InstituteManagementSystem.System.app.Models.Teacher;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class TeacherService { public List<Teacher> listOfTeachers= new CopyOnWriteArrayList<>();
    int currId=1;
    public List<Teacher> getAllTeachers(){
        return listOfTeachers;
    }
    public Teacher getTeacher(int id)
    {
        Optional<Teacher> foundRecord = listOfTeachers.stream().filter(
                (currentTeacher) -> {
                    return currentTeacher.id == id;
                }
        ).findFirst();
        if (foundRecord.isPresent())
        {
            return foundRecord.get();
        }
        else return null;
    }
    public Teacher createTeacher(Teacher currTeacher){
        currTeacher.id = this.currId++;
        listOfTeachers.add(currTeacher);
        return currTeacher;
    }
    public Teacher updateTeacher(int id,Teacher upToDateTeacher){
        Teacher foundTeacher = getTeacher(id);
        foundTeacher.name =upToDateTeacher.name;
        foundTeacher.email = upToDateTeacher.email;
        foundTeacher.salary = upToDateTeacher.salary;
        return foundTeacher;
    }
    public List<Teacher> deleteTeacher(int id){
        Teacher foundTeacher = getTeacher(id);
        listOfTeachers.remove(foundTeacher);
        return listOfTeachers;
    }
}
