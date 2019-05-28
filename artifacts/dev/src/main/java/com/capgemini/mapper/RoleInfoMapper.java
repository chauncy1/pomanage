package com.capgemini.mapper;

import java.util.List;

import com.capgemini.entity.RoleInfoEntity;


/**
 * @author zexuan.jin@capgemini.com(Jason)
 * @date 17/11/2018 2:33 AM
 * @description
 */
public interface RoleInfoMapper {

    //  新建项目主体
    void saveRoleInfoEntity(RoleInfoEntity roleInfoEntity);

    RoleInfoEntity queryRoleInfoById(Integer id);

    void deleteRoleInfoById(Integer id);

    void updateRoleInfoById(RoleInfoEntity roleInfoEntity);

//    void updateRoleInfoAmountById(RoleInfoEntity roleInfoEntity);

    List<RoleInfoEntity> queryRoleInfoByPoId(Integer poId);

}
