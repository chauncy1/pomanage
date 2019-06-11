package com.capgemini.mapper;


import java.util.List;

import com.capgemini.entity.PoInfoEntity;

public interface PoInfoMapper {

    PoInfoEntity queryPoInfoById(Integer id);

    PoInfoEntity queryPoInfoByPoNo(String poNo);

    //  新建项目主体
    void savePoInfoEntity(PoInfoEntity poInfoEntity);

    void updatePoInfoEntity(PoInfoEntity poInfoEntity);

    void deletePoInfoByCode(String code);

    void deletePoInfoById(Integer id);

    List<PoInfoEntity> queryPoInfos();

    //  通过code检索项目
    List<PoInfoEntity> queryPoInfosByCode(String code);

}