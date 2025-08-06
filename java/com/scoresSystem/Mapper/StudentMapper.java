package com.scoresSystem.Mapper;

import com.scoresSystem.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    List<Student> Login(String username, String password);
    List<Student> getAllStudents();
    List<Student> getAllStudentByPage(Map<String,Object> map);
    Student getStudentByNo(int No);
    int addStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(Integer No);
    int countStudent(Map<String,Object> map);
}
