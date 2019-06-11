package com.capgemini.dto;


import java.io.Serializable;

import lombok.Data;

@Data
public class ProjectInfoDto implements Serializable {

    private static final long serialVersionUID = 1L;
    //Sprint 2 创建字段

    //主键
    private Integer id;

    //珊瑚岛
    private String account;

    //  '项目CODE'
    private String code;

    //项目名称
    private String projectName;

    //项目备注
    private String projectComment;

    //项目总监
    private String projectEm;

    //项目经理
    private String projectDm;

    //项目描述
    private String projectDesc;

    //项目开始时间
    private String startDate;

    //项目结束时间
    private String endDate;

    //记录创建时间
    private String createDate;

    //记录更新时间
    private String lastupdateDate;

    //创建者
    private Integer creatBy;

    //更新者
    private Integer lastupdateBy;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
