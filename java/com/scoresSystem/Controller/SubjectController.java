package com.scoresSystem.Controller;

import Tools.Results;
import com.scoresSystem.Service.SubjectService;
import com.scoresSystem.pojo.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/subject")
@RestController
public class SubjectController {
    @Resource
    SubjectService subjectService;

    @RequestMapping("/getAllSubject")
    public Results listSubject(HttpServletRequest request) {
        String subjectName = request.getParameter("subjectName");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        if (page == null || page == " ") page = "1";
        if (limit == null || limit == " ") limit = "10";
        int pageIndex = Integer.parseInt(page);
        int pageSize = Integer.parseInt(limit);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pagestart", (pageIndex - 1) * pageSize);
        result.put("pagesize", pageSize);
        result.put("subjectName", subjectName);
        return subjectService.getSubjectByPage(result);
    }

    @RequestMapping("/addSubject")
    public Results addSubject(Subject subject) {
        System.out.println(subject);
        int count = subjectService.addSubject(subject);
        Results result = new Results();
        if (count == 1) {
            result.setCode(0);
            result.setMsg("添加成功");
            result.setData(subject);
            result.setCount(1);
        } else {
            result.setCode(-1);
            result.setMsg("添加失败");
            result.setData(null);
            result.setCount(0);
        }
        return result;
}

@RequestMapping("/updateSubject")
public Results updateSubject(Subject subject) {
    System.out.println(subject);
    return ResponseMsg(subjectService.updateSubject(subject));
}

@PostMapping("/deleteSubject")
public Results deleteSubject(Subject subject) {
    return ResponseMsg(subjectService.deleteSubject(subject.getId()));

}
@RequestMapping("/subjectSelect")
public Results studentSelect() {
        return subjectService.getAllSubject();
}
public Results ResponseMsg(int count) {
    Boolean State = count > 0 ? true : false;
    int code = count > 0 ? 0 : 1;
    return new Results(code, State.toString(), null, count);
}
}
