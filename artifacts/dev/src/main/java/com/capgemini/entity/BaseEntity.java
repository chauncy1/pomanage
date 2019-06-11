package com.capgemini.entity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BaseEntity {


    private Long id;

    private Long createBy = -1L;  //-1 as system user

    private Timestamp createDate;

    private Long lastUpdateBy = -1L;  //-1 as system user

    private Timestamp lastUpdateDate;

}
