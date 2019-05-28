package com.capgemini.service;

import com.capgemini.dto.ConInfoDto;
import com.capgemini.dto.request.ConInfoSaveRequest;
import com.capgemini.dto.response.CommonResponse;
import com.capgemini.dto.response.ConInfoQueryResponse;
import com.capgemini.entity.ConInfoEntity;
import com.capgemini.entity.PoInfoEntity;
import com.capgemini.entity.RoleInfoEntity;
import com.capgemini.mapper.ConInfoMapper;
import com.capgemini.mapper.PoInfoMapper;
import com.capgemini.mapper.RoleInfoMapper;
import com.capgemini.utils.DateUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by flying on 2018/11/29.
 */
@Service
@Transactional
public class  ConInfoService {
    private final static Logger logger = LoggerFactory.getLogger(RoleInfoService.class);

    @Autowired
    private PoInfoMapper poInfoMapper;

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Autowired
    private ConInfoMapper conInfoMapper;


    public CommonResponse saveConInfo(ConInfoSaveRequest request){
        CommonResponse response = new CommonResponse();

        if(request.getData() == null || request.getData().size() == 0){
            response.setCode("210000");
            response.setMsg("请求数据不合法");
            return response;
        }

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        for(ConInfoDto dto : request.getData()){

            ConInfoEntity entity = conInfoMapper.queryConInfoByEmpNo(dto.getEmpNo());
            if(entity != null){
                response.setCode("200001");
                response.setMsg("已存在Consultant");
                return response;
            }


            ConInfoEntity conInfoEntity = new ConInfoEntity();
            conInfoEntity.setId(dto.getId());
            conInfoEntity.setRoleId(dto.getRoleId());
            conInfoEntity.setEmpLevel(dto.getEmpLevel());
            conInfoEntity.setEmpNo(dto.getEmpNo());
            conInfoEntity.setEmpName(dto.getEmpName());
            conInfoEntity.setEmpType(dto.getEmpType());
            conInfoEntity.setEmpRate(dto.getEmpRate());
            conInfoEntity.setTotalManday(dto.getTotalManday());
            conInfoEntity.setTotalAmount(dto.getTotalAmount());
            conInfoEntity.setStartDate(DateUtil.yyyyMMdd2timestamp(dto.getStartDate()));
            conInfoEntity.setEndDate(DateUtil.yyyyMMdd2timestamp(dto.getEndDate()));
            conInfoEntity.setEmpComment(dto.getEmpComment());
            conInfoEntity.setCreateDate(timestamp);
            conInfoEntity.setLastupdateDate(timestamp);
            conInfoMapper.saveConInfoEntity(conInfoEntity);

            RoleInfoEntity roleInfoEntity = roleInfoMapper.queryRoleInfoById(dto.getRoleId());
            roleInfoEntity.setBillableManday(roleInfoEntity.getBillableManday() + dto.getTotalManday());
            roleInfoEntity.setBalanceManday(roleInfoEntity.getBalanceManday() + dto.getTotalManday());
            roleInfoEntity.setTotalAmount(roleInfoEntity.getTotalAmount() + dto.getTotalAmount());
            roleInfoEntity.setBalanceAmount(roleInfoEntity.getBalanceAmount() + dto.getTotalAmount());
            roleInfoMapper.updateRoleInfoById(roleInfoEntity);

            PoInfoEntity poInfoEntity = poInfoMapper.queryPoInfoById(roleInfoEntity.getPoId());
            poInfoEntity.setPoInitialTotalManday(poInfoEntity.getPoInitialTotalManday() + dto.getTotalManday());
            poInfoEntity.setBalanceManday(poInfoEntity.getBalanceManday() + dto.getTotalManday());
            poInfoEntity.setPoTotalAmountEx(poInfoEntity.getPoTotalAmountEx() + dto.getTotalAmount());
            poInfoEntity.setPoTotalAmountIn(poInfoEntity.getPoTotalAmountEx() * (1 + poInfoEntity.getVat() * 0.01));
            poInfoEntity.setPoAvailableAmtIn(poInfoEntity.getPoAvailableAmtIn() + conInfoEntity.getTotalAmount() * (1 + poInfoEntity.getVat() * 0.01));
            poInfoMapper.updatePoInfoEntity(poInfoEntity);
        }

        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }


    public ConInfoQueryResponse queryConInfoById(Integer id){
        ConInfoQueryResponse response = new ConInfoQueryResponse();

        ConInfoEntity entity = conInfoMapper.queryConInfoById(id);
        response.getData().add(conInfoEntity2Dto(entity));

        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }

    public ConInfoDto viewConInfoById(Integer id){
        ConInfoEntity entity = conInfoMapper.queryConInfoById(id);

        return conInfoEntity2Dto(entity);
    }

    public ConInfoQueryResponse queryConInfoByRoleId(Integer poId){
        ConInfoQueryResponse response = new ConInfoQueryResponse();

        List<ConInfoEntity> entityList = conInfoMapper.queryConInfoByRoleId(poId);
        for (ConInfoEntity entity : entityList){
            response.getData().add(conInfoEntity2Dto(entity));
        }

        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }

    public CommonResponse updateConInfoById(ConInfoSaveRequest request){
        CommonResponse response = new CommonResponse();

        if(request.getData() == null || request.getData().size() == 0){
            response.setCode("210000");
            response.setMsg("请求数据不合法");
            return response;
        }

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        for(ConInfoDto dto : request.getData()){
            Integer id = dto.getId();
            ConInfoEntity entity = conInfoMapper.queryConInfoById(id);
            if(entity == null){
                response.setCode("210000");
                response.setMsg("业务数据不合法");
                return response;
            }

            ConInfoEntity conInfoEntity = new ConInfoEntity();
            conInfoEntity.setRoleId(dto.getRoleId());
            conInfoEntity.setEmpType(dto.getEmpType());
            conInfoEntity.setEmpNo(dto.getEmpNo());
            conInfoEntity.setEmpName(dto.getEmpName());
            conInfoEntity.setEmpRate(dto.getEmpRate());
            conInfoEntity.setTotalManday(dto.getTotalManday());
            conInfoEntity.setEmpComment(dto.getEmpComment());
            conInfoEntity.setLastupdateDate(timestamp);
            conInfoEntity.setId(dto.getId());
            conInfoEntity.setEmpLevel(dto.getEmpLevel());
            conInfoEntity.setTotalAmount(dto.getTotalAmount());
            conInfoMapper.updateConInfoById(conInfoEntity);

        }

        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }


    public CommonResponse deleteConInfoById(Integer id){
        CommonResponse response = new CommonResponse();

        ConInfoEntity conInfoEntity = conInfoMapper.queryConInfoById(id);

        RoleInfoEntity roleInfoEntity = roleInfoMapper.queryRoleInfoById(conInfoEntity.getRoleId());

        roleInfoEntity.setBillableManday(roleInfoEntity.getBillableManday() - conInfoEntity.getTotalManday());
        roleInfoEntity.setBalanceManday(roleInfoEntity.getBalanceManday() - conInfoEntity.getTotalManday());
        roleInfoEntity.setTotalAmount(roleInfoEntity.getTotalAmount() - conInfoEntity.getTotalAmount());
        roleInfoEntity.setBalanceAmount(roleInfoEntity.getBalanceAmount() - conInfoEntity.getTotalAmount());
        roleInfoMapper.updateRoleInfoById(roleInfoEntity);

        PoInfoEntity poInfoEntity = poInfoMapper.queryPoInfoById(roleInfoEntity.getPoId());

        poInfoEntity.setPoInitialTotalManday(poInfoEntity.getPoInitialTotalManday() - conInfoEntity.getTotalManday());
        poInfoEntity.setBalanceManday(poInfoEntity.getBalanceManday() - conInfoEntity.getTotalManday());
        poInfoEntity.setPoTotalAmountEx(poInfoEntity.getPoTotalAmountEx() - conInfoEntity.getTotalAmount());
        poInfoEntity.setPoTotalAmountIn(poInfoEntity.getPoTotalAmountEx() * (1 + poInfoEntity.getVat() * 0.01));
        poInfoEntity.setPoAvailableAmtIn(poInfoEntity.getPoAvailableAmtIn() - conInfoEntity.getTotalAmount() * (1 + poInfoEntity.getVat() * 0.01));

        poInfoMapper.updatePoInfoEntity(poInfoEntity);

        conInfoMapper.deleteConInfoById(id);

        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }

    public List<ConInfoDto> viewConInfoByRoleId(Integer roleId){
        List<ConInfoDto> dtos = new ArrayList<>();

        List<ConInfoEntity> entityList = conInfoMapper.queryConInfoByRoleId(roleId);
        for (ConInfoEntity entity : entityList){
            dtos.add(conInfoEntity2Dto(entity));
        }

        return dtos;
    }

    public ConInfoDto conInfoEntity2Dto(ConInfoEntity entity) {
        if (entity == null) {
            return null;
        }

        ConInfoDto dto = new ConInfoDto();

        dto.setId(entity.getId());
        dto.setEmpNo(entity.getEmpNo());
        dto.setEmpName(entity.getEmpName());
        dto.setEmpType(entity.getEmpType());
        dto.setEmpRate(entity.getEmpRate());
        dto.setTotalManday(entity.getTotalManday());
        dto.setEmpLevel(entity.getEmpLevel());
        dto.setEmpComment(entity.getEmpComment());
        dto.setRoleId(entity.getRoleId());
        dto.setCreateDate(DateUtil.timestamp2yyyyMMdd(entity.getCreateDate()));
        dto.setLastupdateDate(DateUtil.timestamp2yyyyMMdd(entity.getLastupdateDate()));
        dto.setTotalAmount(entity.getTotalAmount());

        return dto;
    }
}
