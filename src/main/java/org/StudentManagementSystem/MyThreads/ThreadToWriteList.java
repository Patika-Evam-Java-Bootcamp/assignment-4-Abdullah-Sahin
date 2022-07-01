package org.StudentManagementSystem.MyThreads;

import jdk.nashorn.internal.parser.JSONParser;
import org.StudentManagementSystem.Student.Student;

import java.util.List;

public class ThreadToWriteList implements Runnable{

    private List<Student> students;

    @Override
    public void run() {
        students.forEach(System.out::println);
    }

    public ThreadToWriteList(List<Student> students) {
        this.students = students;
    }

}
