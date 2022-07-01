package org.StudentManagementSystem.MyThreads;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.StudentManagementSystem.Help.Constants;
import org.StudentManagementSystem.Student.Student;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ThreadToReadJSON implements Runnable {

    private List<Student> students;
    private File file;
    private static boolean isRead = false;

    public ThreadToReadJSON(File file, List<Student> students) throws IOException {
        this.file = file;
        this.students = students;
    }


    @Override
    public void run() {
        isRead = false;
        ObjectMapper mapper = new ObjectMapper();
        try {
            students = mapper.readValue(file, new TypeReference<List<Student>>() {
            });
            isRead = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
