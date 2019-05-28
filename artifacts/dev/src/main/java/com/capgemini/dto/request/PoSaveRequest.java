package com.capgemini.dto.request;

import java.io.Serializable;
import java.util.List;

import com.capgemini.dto.PoInfoDto;


/**
 * @author zexuan.jin@capgemini.com(Jason)
 * @date 17/11/2018 2:33 AM
 * @description
 */
public class PoSaveRequest implements Serializable {

    private static final long serialVersionUID = 1L;


    private List<PoInfoDto> data;

    public List<PoInfoDto> getData() {
        return data;
    }

    public void setData(List<PoInfoDto> data) {
        this.data = data;
    }

}
