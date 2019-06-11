package com.capgemini.entity;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class ProjectInfoEntity {
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
    private Timestamp startDate;

    //项目结束时间
    private Timestamp endDate;

    //记录创建时间
    private Timestamp createDate;

    //记录更新时间
    private Timestamp lastupdateDate;

    //创建者
    private Integer creatBy = -1;

    //更新者
    private Integer lastupdateBy = -1;

}
