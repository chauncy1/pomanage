package com.capgemini.dto.request;


import java.util.List;

import com.capgemini.dto.ConInfoDto;

/**
 * Created by flying on 2018/11/29.
 */
public class ConInfoSaveRequest {
    private static final long serialVersionUID = 1L;


    private List<ConInfoDto> data;

    public List<ConInfoDto> getData() {
        return data;
    }

    public void setData(List<ConInfoDto> data) {
        this.data = data;
    }
}
