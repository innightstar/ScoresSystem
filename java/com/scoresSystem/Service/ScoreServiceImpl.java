package com.scoresSystem.Service;

import Tools.Results;
import com.scoresSystem.Mapper.ScoreMapper;
import com.scoresSystem.pojo.Score;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Resource
    ScoreMapper scoreMapper;

    @Override
    public Results getScores(Map<String, Object> map) {
        List<Score> list = scoreMapper.getAllScoreByPage(map);
        boolean state = !list.isEmpty();
        int count = scoreMapper.countScoreByPage(map);
        String msg = state ? "获取成功" : "获取失败";
        int code = state ? 0 : 1;

        // 预处理：转换为Map列表（每个Map对应一行数据）
        List<Map<String, Object>> result = new ArrayList<>();
        for (Score s : list) {
            Map<String, Object> row = new HashMap<>();
            row.put("id", s.getScoresId());
            row.put("score", s.getScore());

            // 安全获取嵌套对象属性
            row.put("studentName",
                    s.getStudent() != null ? s.getStudent().getStudentName() : null);
            row.put("subjectName",
                    s.getSubject() != null ? s.getSubject().getName() : null);
            row.put("studentNo",
                    s.getStudent() != null ? s.getStudent().getStudentNo() : null);
            row.put("subjectId",
                    s.getSubject() != null ? s.getSubject().getId() : null);
            result.add(row);
        }
        return new Results<>(code, msg, result, count); // 返回处理后的result而非原始list
    }

    @Override
    public Results deleteScores(Integer scoreId) {
        int count=scoreMapper.deleteScoreByScoreId(scoreId);
        return new Results<>(count>0?0:1,count>0?"删除成功":"删除失败",null,count);
    }

    @Override
    public Results insertScores(Score score) {
        int count=scoreMapper.insertScore(score);
        boolean state=count>0;
        int code = state ? 0 : 1;
        String msg=state?"新增成功":"新增失败";
        return new Results<>(code,msg,null,count);
    }

    @Override
    public Results updateScores(Score score) {
        int count=scoreMapper.updateScore(score);
        boolean state=count>0;
        int code = state ? 0 : 1;
        String msg=state?"更新成功":"更新失败";
        return new Results<>(code,msg,null,count);
    }
}
