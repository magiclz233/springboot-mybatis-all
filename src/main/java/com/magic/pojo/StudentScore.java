package com.magic.pojo;

import lombok.Data;

/**
 * @ClassName ClassScore
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/21 10:19
 * @Version 1.0
 */
@Data
public class StudentScore {
    private Integer studentId;
    private String studentName;
    private String department;
    private String className;
    private String grade;
}
