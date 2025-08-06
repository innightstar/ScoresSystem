package com.scoresSystem.Controller;

import Tools.Results;
import com.scoresSystem.Service.StudentService;
import com.scoresSystem.Service.TeacherService;
import com.scoresSystem.pojo.Teacher;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    TeacherService teacherService;
    StudentService studentService;

    @RequestMapping("/login")
    public Results Login(HttpServletRequest request, HttpSession session) {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String sysCode = request.getParameter("sysCode");
        String rightCode = session.getAttribute("systemCode").toString();
        if(!sysCode.equals(rightCode)) { return new Results(5,"验证码错误",null,0); }
        Teacher data=teacherService.loginTeacher(username, password);
        boolean state= data!= null;
        int code=state?0:1;
        String msg=state?"success":"fail";
        if(state) session.setAttribute("user",data.getName());
        return new Results<>(code,msg,data,code);
    }
    @RequestMapping("/getSession")
    public Map<String, Object> getSession(HttpSession session) {
        String username = (String) session.getAttribute("user");
        return new Results<String>(0,"success",username,0).getMap();
    }
    @RequestMapping("/loginOut")
    public Map<String, Object> loginOut(HttpSession session) {
        session.removeAttribute("user");
        return new Results<String>(0,"success",null,0).getMap();
    }

}
