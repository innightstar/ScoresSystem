package com.scoresSystem.Service;

import Tools.Results;
import com.scoresSystem.Mapper.SubjectMapper;
import com.scoresSystem.pojo.Student;
import com.scoresSystem.pojo.Subject;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class SubjectServiceImpl implements SubjectService {
    @Resource
    SubjectMapper subjectMapper;
    @Override
    public Results getSubjectByPage(Map<String, Object> param) {
        List<Student> list=subjectMapper.getAllSubjectByPage(param);
        int count=subjectMapper.countSubject(param);
        return new Results(0,"success",list,count);
    }

    @Override
    public int addSubject(Subject subject) {
        return subjectMapper.addSubject(subject);
    }

    @Override
    public int updateSubject(Subject subject) {
        return subjectMapper.updateSubject(subject);
    }

    @Override
    public int deleteSubject(Integer id) {
        return subjectMapper.deleteSubject(id);
    }

    @Override
    public Results getAllSubject() {
        List<Subject> list=subjectMapper.getAllSubject();
        int count= list.size();
        return new Results(count>0?0:1,count>0?"success":"error",list,count);
    }
}
