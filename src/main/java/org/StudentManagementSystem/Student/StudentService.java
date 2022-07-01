package org.StudentManagementSystem.Student;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StudentService{

    public List<Student> getAllStudents(File file) throws IOException {
        return new ObjectMapper().readValue(file, new TypeReference<List<Student>>(){});
    }


    public Student addStudent(File file, Student student){
        try{
            List<Student> students = getAllStudents(file);
            students.add(student);
            new ObjectMapper().writeValue(file, students);
            return student;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
