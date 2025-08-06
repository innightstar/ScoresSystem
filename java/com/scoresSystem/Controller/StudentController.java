package com.scoresSystem.Controller;

import Tools.Results;
import com.scoresSystem.Service.StudentService;
import com.scoresSystem.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RequestMapping("/student")
@RestController
public class StudentController {
    @Resource
    private StudentService studentService;

    @RequestMapping("/Login")
    public Results Login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return ResponseMsg(studentService.Login(username, password));
    }

    @RequestMapping("/getAllStudent")
    public Results listStudent(HttpServletRequest request) {
        String studentName = request.getParameter("studentName");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        if(page ==null ||page ==" ") page="1";
        if(limit ==null || limit ==" ") limit="10";
        int pageIndex = Integer.parseInt(page);
        int pageSize = Integer.parseInt(limit);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pagestart", (pageIndex - 1) * pageSize);
        result.put("pagesize", pageSize);
        result.put("studentName", studentName);
        return studentService.getStudentByPage(result);
    }
    @RequestMapping("/addStudent")
    public Results addStudent(Student student) {
        int count=studentService.addStudent(student);
        Results result=new Results();
        switch (count){
            case -1: result.setCode(1);result.setMsg("学号已存在");result.setData(null);result.setCount(0);break;
            case 1 : result.setCode(0);result.setMsg("添加成功");result.setData(student);result.setCount(1);break;
            default: result.setCode(-1);result.setMsg("添加失败");result.setData(null);result.setCount(0);break;
        }
        return result;
    }
    @RequestMapping("/updateStudent")
    public Results updateStudent(Student student) {
        System.out.println(student);
        return ResponseMsg(studentService.updateStudent(student));
    }
    @PostMapping("/deleteStudent")
    public Results deleteStudent(Student student) {
        return ResponseMsg(studentService.deleteStudent(student.getStudentNo()));

    }
    @RequestMapping("/studentSelect")
    public Results studentSelect() {
        return studentService.getAllStudents();
    }
    public Results ResponseMsg(int count) {
        Boolean State=count>0?true:false;
        int code=count>0?0:1;
        return new Results(code,State.toString(),null,count);
    }
}
