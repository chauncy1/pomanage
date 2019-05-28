package com.capgemini.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author wenxue.mei@capgemini.com(bruce)
 * @date 02/11/2018 7:16 PM
 * @description
 */
public class BaseEntity {


    private Long id;

    private Long createBy = -1L;  //-1 as system user

    private Timestamp createDate;

    private Long lastUpdateBy = -1L;  //-1 as system user

    private Timestamp lastUpdateDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Long getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Long lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
