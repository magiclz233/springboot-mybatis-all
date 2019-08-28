package com.magic.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class Score implements Serializable {
    private Integer id;

    private Integer studentId;

    private String className;

    private Integer grade;

    private static final long serialVersionUID = 2L;


}