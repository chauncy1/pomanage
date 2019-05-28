package com.capgemini.dto.response;

import java.io.Serializable;

/**
 * @author wenxue.mei@capgemini.com(bruce)
 * @date 02/11/2018 7:26 PM
 * @description 创建项目主题响应对象
 */
public class ProjectSaveResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String msg = "";


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

}
