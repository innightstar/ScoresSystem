package com.scoresSystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    private int id;
    private String name;
    private String description;
    private int time;
    private int valid=1;
}
