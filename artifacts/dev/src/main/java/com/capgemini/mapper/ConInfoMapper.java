package com.capgemini.mapper;



import java.util.List;

import com.capgemini.entity.ConInfoEntity;

/**
 * Created by flying on 2018/11/27.
 */
public interface ConInfoMapper {
    //  新建项目主体
    void saveConInfoEntity(ConInfoEntity conInfoEntity);

    ConInfoEntity queryConInfoById(Integer id);

    ConInfoEntity queryConInfoByEmpNo(String empName);

    void deleteConInfoById(Integer id);

    void updateConInfoById(ConInfoEntity conInfoEntity);

    void updateConInfoAmountById(ConInfoEntity conInfoEntity);

    List<ConInfoEntity> queryConInfoByRoleId(Integer roleId);

}
