package com.capgemini.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zexuan.jin@capgemini.com(Jason)
 * @date 17/11/2018 2:33 AM
 * @description
 */
public class RoleInfoDto implements Serializable {

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
    private String startDate;

    //  '项目结束时间'
    private String endDate;

    //  '记录创建时间',
    private String createDate;

    //  '记录更新时间',
    private String lastupdateDate;

    //  '创建者'
    private Integer creatBy;

    //  '创建者'
    private Integer lastupdateBy;

    //  '人天单价'
    private Double rate;

    //  '总人天'
    private Double billableManday;

    //  '已用人天'
    private Double burnedManday;

    //  '新增已用人天'
    private  Double accrueManday;

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

    public Double getAccrueManday() {
        return accrueManday;
    }

    public void setAccrueManday(Double accrueManday) {
        this.accrueManday = accrueManday;
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
}
