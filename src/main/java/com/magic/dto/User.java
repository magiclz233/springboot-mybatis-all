package com.magic.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;

    private String userName;

    private String birthday;

    private String sex;

    private String address;

    private static final long serialVersionUID = -1L;


}