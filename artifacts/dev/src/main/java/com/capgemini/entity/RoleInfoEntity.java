package com.capgemini.entity;


import java.sql.Timestamp;

import lombok.Data;
/**
 * @author zexuan.jin@capgemini.com(Jason)
 * @date 17/11/2018 2:33 AM
 * @description
 */
@Data
public class RoleInfoEntity {

    private static final long serialVersionUID = 1L;

    private Integer id;

    //  '角色'
    private String poRole;

    //  '总金额（不含税）'
    private Double totalAmountIn;
    private Double totalAmountEx;

    //  '已消耗金额（不含税）'
    private Double burnedAmountIn;
    private Double burnedAmountEx;

    //  '剩余金额（不含税）'
    private Double balanceAmountIn;
    private Double balanceAmountEx;

    //  '人天单价'
    private Double rateIn;
    private Double rateEx;

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
    
//  '开始时间'
    private Timestamp startDate;

    //  '结束时间'
    private Timestamp endDate; 
    
//  '记录创建时间',
    private Timestamp createDate;

    //  '记录更新时间',
    private Timestamp lastupdateDate;

    //  '创建者'
    private Integer creatBy = -1;

    //  '创建者'
    private Integer lastupdateBy = -1;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}