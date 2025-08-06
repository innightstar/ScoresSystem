package com.scoresSystem.Service;

import Tools.Results;
import com.scoresSystem.Mapper.StudentMapper;
import com.scoresSystem.pojo.Student;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Override
    public Results getStudentByPage(Map<String, Object> param) {
        List<Student> list=studentMapper.getAllStudentByPage(param);
        int count=studentMapper.countStudent(param);
        return new Results(0,"success",list,count);

    }
    @Override
    public int addStudent(Student student) {
        return studentMapper.getStudentByNo(student.getStudentNo())==null?studentMapper.addStudent(student):-1;
    }
    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int deleteStudent(Integer No) {
        return studentMapper.deleteStudent(No);
    }

    @Override
    public int Login(String username, String password) {
       return studentMapper.Login(username,password).size();
    }

    @Override
    public Results getAllStudents() {
        List<Student> list=studentMapper.getAllStudents();
        int count= list.size();
        return new Results(count>0?0:1,count>0?"success":"error",list,count);
    }
}
