package com.capgemini.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.dto.ProjectInfoDto;

/**
 * Created by dell on 2018/11/27.
 */
public class ProjectQueryResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;

    private String msg = "";

    private List<ProjectInfoDto> data = new ArrayList<>();


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

    public List<ProjectInfoDto> getData() {
        return data;
    }

    public void setData(List<ProjectInfoDto> data) {
        this.data = data;
    }
}
