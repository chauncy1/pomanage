package com.capgemini.dto;


import java.io.Serializable;

public class PoInfoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    //  '项目CODE'
    private String code;

    //  '项目名称'
    private String poName;

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

    //  '更新者'
    private Integer lastupdateBy;

    //  '订单代码'
    private String poNo;

    //  'PO描述'
    private String poDesc;

    //  'PO状态'
    private String poStatus;

    //  'PO初始总人天'
    private double poInitialTotalManday;

    //  'PO总金额（不含税）'
    private double poTotalAmountEx;

    //  'PO总金额（含税）'
    private double poTotalAmountIn;

    //  '已用金额（含税）'
    private double billedAmtIn;

    //  '可用金额（含税）'
    private double poAvailableAmtIn;

    //  '总使用人天'
    private double totalBurnedManday;

    //  '未使用人天'
    private double balanceManday;

    //  'PO类型'
    private String contentType;

    //  '税率'
    private double vat;

    //  '备注'
    private String poComment;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPoName() {
        return poName;
    }

    public void setPoName(String poName) {
        this.poName = poName;
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

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getPoDesc() {
        return poDesc;
    }

    public void setPoDesc(String poDesc) {
        this.poDesc = poDesc;
    }

    public String getPoStatus() {
        return poStatus;
    }

    public void setPoStatus(String poStatus) {
        this.poStatus = poStatus;
    }

    public double getPoInitialTotalManday() {
        return poInitialTotalManday;
    }

    public void setPoInitialTotalManday(double poInitialTotalManday) {
        this.poInitialTotalManday = poInitialTotalManday;
    }

    public double getPoTotalAmountEx() {
        return poTotalAmountEx;
    }

    public void setPoTotalAmountEx(double poTotalAmountEx) {
        this.poTotalAmountEx = poTotalAmountEx;
    }

    public double getPoTotalAmountIn() {
        return poTotalAmountIn;
    }

    public void setPoTotalAmountIn(double poTotalAmountIn) {
        this.poTotalAmountIn = poTotalAmountIn;
    }

    public double getBilledAmtIn() {
        return billedAmtIn;
    }

    public void setBilledAmtIn(double billedAmtIn) {
        this.billedAmtIn = billedAmtIn;
    }

    public double getPoAvailableAmtIn() {
        return poAvailableAmtIn;
    }

    public void setPoAvailableAmtIn(double poAvailableAmtIn) {
        this.poAvailableAmtIn = poAvailableAmtIn;
    }

    public double getTotalBurnedManday() {
        return totalBurnedManday;
    }

    public void setTotalBurnedManday(double totalBurnedManday) {
        this.totalBurnedManday = totalBurnedManday;
    }

    public double getBalanceManday() {
        return balanceManday;
    }

    public void setBalanceManday(double balanceManday) {
        this.balanceManday = balanceManday;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPoComment() {
        return poComment;
    }

    public void setPoComment(String poComment) {
        this.poComment = poComment;
    }
}