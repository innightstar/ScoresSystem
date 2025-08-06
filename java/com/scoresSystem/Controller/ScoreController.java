package com.scoresSystem.Controller;

import Tools.Results;
import com.scoresSystem.Service.ScoreService;
import com.scoresSystem.pojo.Score;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/score")
@RestController
public class ScoreController {

    @Resource
    ScoreService scoreService;

    @RequestMapping("/getAllScore")
    public Results getAllScore(HttpServletRequest request) {
        String studentName = request.getParameter("studentName");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        int pageIndex=1;
        int pageSize=10;
        if(page!=null&&!page.equals("")) pageIndex=Integer.parseInt(page);
        if(limit!=null&&!limit.equals("")) pageSize=Integer.parseInt(limit);
        Map<String,Object> map=new HashMap<>();
        map.put("studentName",studentName);
        map.put("pageIndex",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        return scoreService.getScores(map);
    }
    @RequestMapping("/deleteScore")
    public Results deleteScore(HttpServletRequest request) {
        String id = request.getParameter("id");
        int scoreId=-1;
        if(id!=null&&!id.equals("")) {
            scoreId = Integer.parseInt(id);
        }
        return scoreService.deleteScores(scoreId);
    }
    @RequestMapping("/addScore")
    public Results addScore(HttpServletRequest request) {
        Score score=new Score();
        score.setScore(Integer.parseInt(request.getParameter("scoreValue")));
        score.setStudentNo(Integer.parseInt(request.getParameter("studentId")));
        score.setSubjectId(Integer.parseInt(request.getParameter("subjectId")));
        System.out.println(score);
        return scoreService.insertScores(score);
    }
    @RequestMapping("/updateScore")
    public Results updateScore(Score score) {
        System.out.println(score);
        return scoreService.updateScores(score);
    }

}
