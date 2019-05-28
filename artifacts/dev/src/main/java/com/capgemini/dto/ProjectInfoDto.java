package com.capgemini.dto;


import java.io.Serializable;

/**
 * Created by dell on 2018/11/27.
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectComment() {
        return projectComment;
    }

    public void setProjectComment(String projectComment) {
        this.projectComment = projectComment;
    }

    public String getProjectEm() {
        return projectEm;
    }

    public void setProjectEm(String projectEm) {
        this.projectEm = projectEm;
    }

    public String getProjectDm() {
        return projectDm;
    }

    public void setProjectDm(String projectDm) {
        this.projectDm = projectDm;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastupdateDate() {
        return lastupdateDate;
    }

    public void setLastupdateDate(String lastupdateDate) {
        this.lastupdateDate = lastupdateDate;
    }

    public Integer getCreatBy() {
        return creatBy;
    }

    public void setCreatBy(Integer creatBy) {
        this.creatBy = creatBy;
    }

    public Integer getLastupdateBy() {
        return lastupdateBy;
    }

    public void setLastupdateBy(Integer lastupdateBy) {
        this.lastupdateBy = lastupdateBy;
    }
}
