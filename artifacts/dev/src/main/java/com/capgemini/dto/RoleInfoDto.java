package com.capgemini.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * @author zexuan.jin@capgemini.com(Jason)
 * @date 17/11/2018 2:33 AM
 * @description
 */
@Data
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

    //  '记录创建时间',
    private String createDate;

    //  '记录更新时间',
    private String lastupdateDate;

    //  '创建者'
    private Integer creatBy;

    //  '创建者'
    private Integer lastupdateBy;

//  '开始时间'
    private Timestamp startDate;

    //  '结束时间'
    private Timestamp endDate; 
    
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

}
