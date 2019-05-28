package com.capgemini.dto.request;

import java.io.Serializable;
import java.util.List;

import com.capgemini.dto.RoleInfoDto;


/**
 * @author zexuan.jin@capgemini.com(Jason)
 * @date 17/11/2018 2:33 AM
 * @description
 */
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
