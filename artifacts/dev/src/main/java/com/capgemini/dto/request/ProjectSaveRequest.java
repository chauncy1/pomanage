package com.capgemini.dto.request;

import java.io.Serializable;
import java.util.List;

import com.capgemini.dto.ProjectInfoDto;
/**
 * Created by dell on 2018/11/27.
 */
public class ProjectSaveRequest implements Serializable {
    private static final long serialVersionUID = 1L;


    private List<ProjectInfoDto> data;

    public List<ProjectInfoDto> getData() {
        return data;
    }

    public void setData(List<ProjectInfoDto> data) {
        this.data = data;
    }
}
