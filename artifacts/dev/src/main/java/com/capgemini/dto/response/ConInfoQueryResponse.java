package com.capgemini.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.dto.ConInfoDto;

public class ConInfoQueryResponse {
    private static final long serialVersionUID = 1L;

    private String code;

    private String msg = "";

    private List<ConInfoDto> data = new ArrayList<>();


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

    public List<ConInfoDto> getData() {
        return data;
    }

    public void setData(List<ConInfoDto> data) {
        this.data = data;
    }
}
