package com.capgemini.dto;


import java.io.Serializable;

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

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public Integer getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(Integer remainingDays) {
        this.remainingDays = remainingDays;
    }

}
