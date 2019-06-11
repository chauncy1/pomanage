package com.capgemini.dto.request;

import java.io.Serializable;
import java.util.List;

import com.capgemini.dto.PoInfoDto;


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
