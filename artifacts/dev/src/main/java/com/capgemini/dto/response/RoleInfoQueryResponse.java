package com.capgemini.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.dto.RoleInfoDto;

/**
 * @author wenxue.mei@capgemini.com(bruce)
 * @date 03/11/2018 2:23 PM
 * @description
 */
public class RoleInfoQueryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String msg = "";

    private List<RoleInfoDto> data = new ArrayList<>();


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

    public List<RoleInfoDto> getData() {
        return data;
    }

    public void setData(List<RoleInfoDto> data) {
        this.data = data;
    }

}
