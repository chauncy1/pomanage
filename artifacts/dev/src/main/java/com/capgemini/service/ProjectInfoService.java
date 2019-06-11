package com.capgemini.service;

import com.capgemini.dto.ProjectInfoDto;
import com.capgemini.dto.request.ProjectSaveRequest;
import com.capgemini.dto.response.CommonResponse;
import com.capgemini.dto.response.ProjectQueryResponse;
import com.capgemini.entity.PoInfoEntity;
import com.capgemini.entity.ProjectInfoEntity;
import com.capgemini.mapper.PoInfoMapper;
import com.capgemini.mapper.ProjectInfoMapper;
import com.capgemini.utils.DateUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProjectInfoService {
    private final static Logger logger = LoggerFactory.getLogger(ProjectInfoService.class);

    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    @Autowired
    private PoInfoMapper poInfoMapper;

    @Transactional
    public CommonResponse saveProjectInfo(@RequestBody ProjectSaveRequest request){
        CommonResponse response = new CommonResponse();

        if(request.getData() == null || request.getData().size() == 0){
            response.setCode("210000");
            response.setMsg("请求数据不合法");
            return response;
        }

        StringBuffer sb = new StringBuffer();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        List<ProjectInfoEntity> toDbs = new ArrayList<>();
        for(ProjectInfoDto dto : request.getData()){
            ProjectInfoEntity entity = new ProjectInfoEntity();

            ProjectInfoEntity dbs = projectInfoMapper.queryProjectInfoByCode(dto.getCode());
            if(dbs != null){
                sb.append(dto.getCode());
//                sb.append(",");

                continue;
            }

            entity.setCode(dto.getCode());
            entity.setAccount(dto.getAccount());
            entity.setProjectName(dto.getProjectName());
            entity.setProjectComment(dto.getProjectComment());
            entity.setProjectEm(dto.getProjectEm());
            entity.setProjectDm(dto.getProjectDm());
            entity.setProjectDesc(dto.getProjectDesc());
            entity.setStartDate(DateUtil.yyyyMMdd2timestamp(dto.getStartDate()));
            entity.setEndDate(DateUtil.yyyyMMdd2timestamp(dto.getEndDate()));
            entity.setCreateDate(timestamp);
            entity.setLastupdateDate(timestamp);
            toDbs.add(entity);
        }

        if(sb.length() > 0){
            response.setCode("200001");
            response.setMsg("已存在CODE：" + sb);
            return response;
        }

        for(ProjectInfoEntity entity : toDbs){
            projectInfoMapper.saveProjectInfoEntity(entity);
        }

        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }

    public CommonResponse updateProjectInfo(ProjectSaveRequest request){
        CommonResponse response = new CommonResponse();

        if(request.getData() == null || request.getData().size() == 0){
            response.setCode("210000");
            response.setMsg("请求数据不合法");
            return response;
        }

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        List<ProjectInfoEntity> toDbs = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for(ProjectInfoDto dto : request.getData()){
            ProjectInfoEntity entity = new ProjectInfoEntity();
            ProjectInfoEntity db = projectInfoMapper.queryProjectInfoByCode(dto.getCode());
            if(db == null){
                sb.append(dto.getCode() + "，项目不存在");
                sb.append(",");

                continue;
            }

            entity.setId(dto.getId());
            entity.setCode(dto.getCode());
            entity.setAccount(dto.getAccount());
            entity.setProjectName(dto.getProjectName());
            entity.setProjectComment(dto.getProjectComment());
            entity.setProjectEm(dto.getProjectEm());
            entity.setProjectDm(dto.getProjectDm());
            entity.setProjectDesc(dto.getProjectDesc());
            entity.setStartDate(DateUtil.yyyyMMdd2timestamp(dto.getStartDate()));
            entity.setEndDate(DateUtil.yyyyMMdd2timestamp(dto.getEndDate()));
            entity.setCreateDate(timestamp);
            entity.setLastupdateDate(timestamp);
            toDbs.add(entity);
        }

        if(sb.length() > 0){
            response.setCode("200001");
            response.setMsg(sb.substring(0, sb.length()-1));
            return response;
        }

        for(ProjectInfoEntity entity : toDbs){
            projectInfoMapper.updateProjectInfoEntity(entity);
        }

        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }

    public CommonResponse deleteProjectById(Integer id){
        CommonResponse response = new CommonResponse();

        ProjectInfoEntity entity = projectInfoMapper.queryProjectInfoById(id);
        if(entity == null){
            response.setCode("200001");
            response.setMsg("项目不存在");

            return response;
        }

        List<PoInfoEntity> poInfoEntities = poInfoMapper.queryPoInfosByCode(entity.getCode());
        if(poInfoEntities.size() != 0){
            response.setCode("220000");
            response.setMsg("There are POs in this Project!");
            return response;
        }

        projectInfoMapper.deleteProjectInfoById(id);


        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }

    public ProjectQueryResponse queryPoByCode(String code){
        ProjectQueryResponse response = new ProjectQueryResponse();
        response.setCode("200000");
        response.setMsg("OK");

        List<ProjectInfoEntity> entityList = projectInfoMapper.queryProjectInfosByCode(code);
        if(entityList != null && entityList.size() >0){
            for(ProjectInfoEntity entity : entityList){
                response.getData().add(projectEntity2Dto(entity));
            }
        }
        return response;
    }

    public ProjectInfoDto queryProjectById(Integer id){
        ProjectInfoEntity entity = projectInfoMapper.queryProjectInfoById(id);

        return projectEntity2Dto(entity);
    }

    public ProjectInfoDto queryProjectByCode(String code){
        ProjectInfoEntity entity = projectInfoMapper.queryProjectInfoByCode(code);

        return projectEntity2Dto(entity);
    }

    public List<ProjectInfoDto> viewProject(){
        List<ProjectInfoDto> data = new ArrayList<>();

        List<ProjectInfoEntity> entityList = new ArrayList<>();
            entityList = projectInfoMapper.queryProjectInfos();

        if(entityList != null && entityList.size() >0){
            for(ProjectInfoEntity entity : entityList){
                data.add(projectEntity2Dto(entity));
            }
        }
        return data;
    }


    private ProjectInfoDto projectEntity2Dto(ProjectInfoEntity entity){
        if(entity == null){
            return null;
        }

        ProjectInfoDto dto = new ProjectInfoDto();

        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setAccount(entity.getAccount());
        dto.setProjectName(entity.getProjectName());
        dto.setProjectComment(entity.getProjectComment());
        dto.setProjectEm(entity.getProjectEm());
        dto.setProjectDm(entity.getProjectDm());
        dto.setProjectDesc(entity.getProjectDesc());
        dto.setStartDate(DateUtil.timestamp2yyyyMMdd(entity.getStartDate()));
        dto.setEndDate(DateUtil.timestamp2yyyyMMdd(entity.getEndDate()));
        dto.setCreateDate(DateUtil.timestamp2yyyyMMdd(entity.getCreateDate()));
        dto.setLastupdateDate(DateUtil.timestamp2yyyyMMdd(entity.getLastupdateDate()));


        return dto;
    }
}
