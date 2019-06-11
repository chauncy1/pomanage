package com.capgemini.dto.request;


import java.util.List;

import com.capgemini.dto.ConInfoDto;

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
