package com.scoresSystem.Service;

import Tools.Results;
import com.scoresSystem.pojo.Student;

import java.util.Map;


public interface StudentService {
    Results getStudentByPage(Map<String, Object> param);
    int addStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(Integer No);
    int Login(String username, String password);
    Results getAllStudents();
}
