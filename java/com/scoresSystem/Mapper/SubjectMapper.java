package com.scoresSystem.Mapper;

import com.scoresSystem.pojo.Student;
import com.scoresSystem.pojo.Subject;

import java.util.List;
import java.util.Map;

public interface SubjectMapper {
    List<Student> getAllSubjectByPage(Map<String,Object> map);
    int addSubject(Subject subject);
    int updateSubject(Subject subject);
    int deleteSubject(Integer No);
    int countSubject(Map<String, Object> param);
    List<Subject> getAllSubject();
}
