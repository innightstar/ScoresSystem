package com.scoresSystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private  Integer studentNo;
    private String studentName;
    private String studentSex;
    private String studentAge;
    private String  studentBirthday;
    private String studentPassword="123456";
    private Integer studentValid=1;

}
