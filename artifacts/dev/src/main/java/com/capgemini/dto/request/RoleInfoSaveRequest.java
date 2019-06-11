package com.capgemini.dto.request;

import java.io.Serializable;
import java.util.List;

import com.capgemini.dto.RoleInfoDto;

public class RoleInfoSaveRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<RoleInfoDto> data;


    public List<RoleInfoDto> getData() {
        return data;
    }

    public void setData(List<RoleInfoDto> data) {
        this.data = data;
    }

}
