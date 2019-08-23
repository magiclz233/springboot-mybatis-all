package com.magic.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Student implements Serializable {
    private Integer id;

    private String name;

    private String sex;

    private Date birthday;

    private String department;

    private String address;

    private static final long serialVersionUID = 1L;


}