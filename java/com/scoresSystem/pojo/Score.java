package com.scoresSystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    private int scoresId;
    private int studentNo;
    private int subjectId;
    private int score;
    private int valid;

    public Score(int scoresId, int studentNo, int subjectId, int score) {
        this.scoresId = scoresId;
        this.studentNo = studentNo;
        this.subjectId = subjectId;
        this.score = score;
    }

    private Student student;
    private Subject subject;
}
