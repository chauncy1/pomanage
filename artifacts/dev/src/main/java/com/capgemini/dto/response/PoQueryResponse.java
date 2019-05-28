package com.capgemini.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.dto.PoInfoDto;

/**
 * @author wenxue.mei@capgemini.com(bruce)
 * @date 03/11/2018 1:15 PM
 * @description
 */
public class PoQueryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String msg = "";

    private List<PoInfoDto> data = new ArrayList<>();


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<PoInfoDto> getData() {
        return data;
    }

    public void setData(List<PoInfoDto> data) {
        this.data = data;
    }

}
