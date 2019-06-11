package com.capgemini.entity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ConInfoEntity {

    private static final long serialVersionUID = 1L;

    private Integer id;

    //  '顾问NO'
    private String empNo;

    //  '顾问名'
    private String empName;

    //  '顾问类型'
    private String empType;

    // '人天单价'
    private Double empRate;

    //  '总人天'
    private Double totalManday;

    //  '总金额'
    private Double totalAmount;

    //  '顾问等级'
    private String empLevel;

    //  '项目开始时间'
    private Timestamp startDate;

    //  '项目结束时间'
    private Timestamp endDate;

    //  '备注'
    private String empComment;

    //  '创建时间'
    private Timestamp createDate;

    //  '更新时间'
    private Timestamp lastupdateDate;

    //  '创建者'
    private Integer creatBy = -1;

    //  '更新者'
    private Integer lastupdateBy = -1;

    //  'ROLE主表ID'
    private Integer roleId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}
