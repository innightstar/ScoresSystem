package com.scoresSystem.Service;

import Tools.Results;
import com.scoresSystem.pojo.Subject;

import java.util.Map;

public interface SubjectService {
    Results getSubjectByPage(Map<String, Object> param);
    int addSubject(Subject student);
    int updateSubject(Subject student);
    int deleteSubject(Integer id);
    Results getAllSubject();
}
