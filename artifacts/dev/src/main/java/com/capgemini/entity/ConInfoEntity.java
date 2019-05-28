package com.capgemini.entity;

import java.sql.Timestamp;

/**
 * Created by flying on 2018/11/27.
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public Double getEmpRate() {
        return empRate;
    }

    public void setEmpRate(Double empRate) {
        this.empRate = empRate;
    }

    public Double getTotalManday() {
        return totalManday;
    }

    public void setTotalManday(Double totalManday) {
        this.totalManday = totalManday;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getEmpLevel() {
        return empLevel;
    }

    public void setEmpLevel(String empLevel) {
        this.empLevel = empLevel;
    }

    public String getEmpComment() {
        return empComment;
    }

    public void setEmpComment(String empComment) {
        this.empComment = empComment;
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
}
