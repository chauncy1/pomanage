package com.capgemini.dto;


import java.io.Serializable;

import lombok.Data;

@Data
public class ExpiringPoInfoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    //  '项目CODE'
    private String code;

    //  '项目名称'
    private String poName;

    //  'PO代码'
    private String poNo;

    // 'PO剩余天数'
    private Integer remainingDays;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
