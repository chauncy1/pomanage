package com.capgemini.entity;
import java.sql.Timestamp;
/**
 * Created by dell on 2018/11/27.
 */
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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastupdateDate() {
        return lastupdateDate;
    }

    public void setLastupdateDate(Timestamp lastupdateDate) {
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
