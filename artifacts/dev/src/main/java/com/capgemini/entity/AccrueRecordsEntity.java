package com.capgemini.entity;


import java.math.BigDecimal;
import java.sql.Timestamp;

public class AccrueRecordsEntity {

    private Integer id;

    //  'ACCRUE_COMMENTS'
    private String accrueComments;

    //  'ACCRUE_AMOUNT'
    private BigDecimal accrueAmount;

    //  '记录创建时间',
    private Timestamp createDate;

    //  '记录更新时间',
    private Timestamp lastupdateDate;

    //  '创建者'
    private Integer creatBy = -1;;

    //  '创建者'
    private Integer lastupdateBy = -1;;

    //  项目编号
    private Integer projectDetailId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccrueComments() {
        return accrueComments;
    }

    public void setAccrueComments(String accrueComments) {
        this.accrueComments = accrueComments;
    }

    public BigDecimal getAccrueAmount() {
        return accrueAmount;
    }

    public void setAccrueAmount(BigDecimal accrueAmount) {
        this.accrueAmount = accrueAmount;
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

    public Integer getProjectDetailId() {
        return projectDetailId;
    }

    public void setProjectDetailId(Integer projectDetailId) {
        this.projectDetailId = projectDetailId;
    }

}