package com.capgemini.mapper;

import java.util.List;

import com.capgemini.entity.ProjectInfoEntity;
public interface ProjectInfoMapper {
    ProjectInfoEntity queryProjectInfoById(Integer id);

    ProjectInfoEntity queryProjectInfoByCode(String code);

    //  新建项目主体
    void saveProjectInfoEntity(ProjectInfoEntity projectInfoEntity);

    void updateProjectInfoEntity(ProjectInfoEntity projectInfoEntity);

    void deleteProjectInfoById(Integer id);

    List<ProjectInfoEntity> queryProjectInfos();

    //  通过code检索项目
    List<ProjectInfoEntity> queryProjectInfosByCode(String code);
}
