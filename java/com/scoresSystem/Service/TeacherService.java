package com.scoresSystem.Service;

import com.scoresSystem.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher getTeacher(int id);
    List<Teacher> findAllTeachers();
    Teacher loginTeacher(String username, String password);
}
