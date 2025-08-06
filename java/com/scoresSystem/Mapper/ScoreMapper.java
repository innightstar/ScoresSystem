package com.scoresSystem.Mapper;

import com.scoresSystem.pojo.Score;

import java.util.List;
import java.util.Map;

public interface ScoreMapper {
    List<Score> getAllScoreByPage(Map<String, Object> map);
    int countScoreByPage(Map<String, Object> map);
    int deleteScoreByScoreId(Integer scoreId);
    int insertScore(Score score);
    int updateScore(Score score);
}
