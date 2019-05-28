package com.capgemini.entity;


import java.math.BigDecimal;
import java.sql.Timestamp;
/**
 * @author zexuan.jin@capgemini.com(Jason)
 * @date 17/11/2018 2:33 AM
 * @description
 */
public class RoleInfoEntity {

    private static final long serialVersionUID = 1L;

    private Integer id;

    //  '角色'
    private String poRole;

    //  '总金额（不含税）'
    private Double totalAmount;

    //  '已消耗金额（不含税）'
    private Double burnedAmount;

    //  '剩余金额（不含税）'
    private Double balanceAmount;

    //  '项目开始时间'
    private Timestamp startDate;

    //  '项目结束时间'
    private Timestamp endDate;

    //  '记录创建时间',
    private Timestamp createDate;

    //  '记录更新时间',
    private Timestamp lastupdateDate;

    //  '创建者'
    private Integer creatBy = -1;

    //  '创建者'
    private Integer lastupdateBy = -1;

    //  '人天单价'
    private Double rate;

    //  '总人天'
    private Double billableManday;

    //  '已用人天'
    private Double burnedManday;

    //  '剩余人天'
    private Double balanceManday;

    //  '备注'
    private String roleComment;

    //  'PO主表ID'
    private Integer poId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoRole() {
        return poRole;
    }

    public void setPoRole(String poRole) {
        this.poRole = poRole;
    }


    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getBurnedAmount() {
        return burnedAmount;
    }

    public void setBurnedAmount(Double burnedAmount) {
        this.burnedAmount = burnedAmount;
    }

    public Double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(Double balanceAmount) {
        this.balanceAmount = balanceAmount;
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getBillableManday() {
        return billableManday;
    }

    public void setBillableManday(Double billableManday) {
        this.billableManday = billableManday;
    }

    public Double getBurnedManday() {
        return burnedManday;
    }

    public void setBurnedManday(Double burnedManday) {
        this.burnedManday = burnedManday;
    }

    public Double getBalanceManday() {
        return balanceManday;
    }

    public void setBalanceManday(Double balanceManday) {
        this.balanceManday = balanceManday;
    }

    public String getRoleComment() {
        return roleComment;
    }

    public void setRoleComment(String roleComment) {
        this.roleComment = roleComment;
    }

    public Integer getPoId() {
        return poId;
    }

    public void setPoId(Integer poId) {
        this.poId = poId;
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