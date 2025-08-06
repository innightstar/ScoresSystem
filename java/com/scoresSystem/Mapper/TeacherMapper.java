package com.scoresSystem.Mapper;

import com.scoresSystem.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    Teacher getTeacherById(int id);
    List<Teacher> findAll();
    int insert(Teacher teacher);
    int update();
    int delete(int id);
    List<Teacher> findByTeacherName(String teacherName);
    Teacher loginTeacher(String teacherName, String password);
}
