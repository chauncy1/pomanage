package com.capgemini.dto;


import java.io.Serializable;

import lombok.Data;

@Data
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

}