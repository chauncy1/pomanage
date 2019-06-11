package com.capgemini.dto;

import lombok.Data;

@Data
public class ConInfoDto {

    private static final long serialVersionUID = 1L;

    private Integer id;

    //  '顾问NO'
    private String empNo;

    //  '顾问名'
    private String empName;

    //  '顾问类型'
    private String empType;

    //  '项目开始时间'
    private String startDate;

    //  '项目结束时间'
    private String endDate;

    // '人天单价'
    private Double empRate;

    //  '总人天'
    private Double totalManday;

    //  '总金额'
    private Double totalAmount;

    //  '顾问等级'
    private String empLevel;

    //  '备注'
    private String empComment;

    //  '创建时间'
    private String createDate;

    //  '更新时间'
    private String lastupdateDate;

    //  '创建者'
    private Integer creatBy;

    //  '更新者'
    private Integer lastupdateBy;

    //  'ROLE主表ID'
    private Integer roleId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}