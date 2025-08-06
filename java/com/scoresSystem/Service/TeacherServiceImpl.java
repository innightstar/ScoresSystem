package com.scoresSystem.Service;

import com.scoresSystem.Mapper.TeacherMapper;
import com.scoresSystem.pojo.Teacher;
import lombok.Data;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    TeacherMapper teacherMapper;
    @Override
    public Teacher getTeacher(int id) {
        return teacherMapper.getTeacherById(id);
    }

    @Override
    public List<Teacher> findAllTeachers() {
        return teacherMapper.findAll();
    }

    @Override
    public Teacher loginTeacher(String username, String password) {
    return teacherMapper.loginTeacher(username,password)!=null?teacherMapper.loginTeacher(username,password):null;
    }

}
