package com.capgemini.dto;


/**
 * Created by flying on 2018/11/27.
 */
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}