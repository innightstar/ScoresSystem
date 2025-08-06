package com.scoresSystem.Controller;

import com.scoresSystem.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;


@RequestMapping("/Teacher.action")
@RestController
public class TeacherController extends HttpServlet {
    @Resource
    private TeacherService teacherService;




}
