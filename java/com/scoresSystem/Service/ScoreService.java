package com.scoresSystem.Service;

import Tools.Results;
import com.scoresSystem.pojo.Score;

import java.util.Map;

public interface ScoreService {
    Results getScores(Map<String,Object> map);
    Results deleteScores(Integer scoreId);
    Results insertScores(Score score);
    Results updateScores(Score score);
}
