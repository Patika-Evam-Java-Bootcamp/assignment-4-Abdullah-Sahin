package org.StudentManagementSystem;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.regexp.joni.ast.ConsAltNode;
import org.StudentManagementSystem.Help.Constants;
import org.StudentManagementSystem.MyThreads.ThreadToReadJSON;
import org.StudentManagementSystem.MyThreads.ThreadToWriteList;
import org.StudentManagementSystem.Student.Student;
import org.StudentManagementSystem.Student.StudentService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File(Constants.path);
        List<Student> students = new ArrayList<>();
        Thread t1 = new Thread(new ThreadToReadJSON(file, students));
        Thread t2 = new Thread(new ThreadToWriteList(students));
        t1.start();
        try {
            t1.join();
            t2.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(students.size());
        students.forEach(System.out::println);



        /*

        List<Student> students = mapper.readValue(reader, new TypeReference<List<Student>>(){});
        students.forEach(t -> System.out.println(t.getName()));
        */


    }
}