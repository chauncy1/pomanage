package com.capgemini.entity;


import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class AccrueRecordsEntity {

    private Integer id;

    //  'ACCRUE_COMMENTS'
    private String accrueComments;

    //  'ACCRUE_AMOUNT'
    private Double accrueAmount;

    //  '记录创建时间',
    private Timestamp createDate;

    //  '创建者'
    private Integer creatBy = -1;;

    //  项目编号
    private Integer poId;

}