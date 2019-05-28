package com.capgemini.service;

import com.capgemini.dto.ProjectInfoDto;
import com.capgemini.dto.RoleInfoDto;
import com.capgemini.dto.request.ConInfoSaveRequest;
import com.capgemini.dto.request.RoleInfoSaveRequest;
import com.capgemini.dto.response.CommonResponse;
import com.capgemini.dto.response.RoleInfoQueryResponse;
import com.capgemini.entity.ConInfoEntity;
import com.capgemini.entity.PoInfoEntity;
import com.capgemini.entity.ProjectInfoEntity;
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
 * @author zexuan.jin@capgemini.com(Jason)
 * @date 17/11/2018 2:33 AM
 * @description
 */

@Service
@Transactional
public class RoleInfoService {

    private final static Logger logger = LoggerFactory.getLogger(RoleInfoService.class);

    @Autowired
    private PoInfoMapper poInfoMapper;

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Autowired
    private ConInfoMapper conInfoMapper;


    public CommonResponse saveRoleInfo(RoleInfoSaveRequest request){
        CommonResponse response = new CommonResponse();

        if(request.getData() == null || request.getData().size() == 0){
            response.setCode("210000");
            response.setMsg("请求数据不合法");
            return response;
        }


        Integer count = 0;

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        List<RoleInfoEntity> dbs = new ArrayList<>();
        loop1:for(RoleInfoDto dto : request.getData()){

            List<RoleInfoEntity> roleInfoEntities = roleInfoMapper.queryRoleInfoByPoId(dto.getPoId());
            for(RoleInfoEntity roleInfoEntity : roleInfoEntities){
                if(dto.getPoRole().equals(roleInfoEntity.getPoRole())){
                    count++;
                    continue loop1;
                }
            }

            Integer id = dto.getPoId();
            RoleInfoEntity entity = new RoleInfoEntity();
            entity.setPoRole(dto.getPoRole());
            entity.setRateIn(dto.getRate());
            entity.setRoleComment(dto.getRoleComment());
            entity.setPoId(id);
            entity.setStartDate(dto.getStartDate());
            entity.setEndDate(dto.getEndDate());
            
            entity.setBalanceAmountIn(dto.getBalanceAmount());
            entity.setBalanceManday(dto.getBalanceManday());
            entity.setBillableManday(dto.getBillableManday());
            entity.setBurnedAmountIn(dto.getBurnedAmount());
            entity.setBurnedManday(dto.getBurnedManday());
            entity.setTotalAmountIn(dto.getTotalAmount());
            dbs.add(entity);

        }

        if(count > 0){
            response.setCode("200001");
            response.setMsg("已存在Role");
            return response;
        }

        for(RoleInfoEntity entity : dbs){
            roleInfoMapper.saveRoleInfoEntity(entity);
        }

        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }


    public RoleInfoQueryResponse queryRoleInfoById(Integer id){
        RoleInfoQueryResponse response = new RoleInfoQueryResponse();

        RoleInfoEntity entity = roleInfoMapper.queryRoleInfoById(id);
        response.getData().add(roleInfoEntity2Dto(entity));

        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }

    public RoleInfoDto viewRoleInfoById(Integer id){
        RoleInfoEntity entity = roleInfoMapper.queryRoleInfoById(id);

        return roleInfoEntity2Dto(entity);
    }

    public RoleInfoQueryResponse queryRoleInfoByPoId(Integer poId){
        RoleInfoQueryResponse response = new RoleInfoQueryResponse();

        List<RoleInfoEntity> entityList = roleInfoMapper.queryRoleInfoByPoId(poId);
        List<RoleInfoDto> dtos = new ArrayList<>();
        for (RoleInfoEntity entity : entityList){
            dtos.add(roleInfoEntity2Dto(entity));
        }
        response.setData(dtos);
        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }

    public CommonResponse updateRoleInfoById(RoleInfoSaveRequest request){
        CommonResponse response = new CommonResponse();

        if(request.getData() == null || request.getData().size() == 0){
            response.setCode("210000");
            response.setMsg("请求数据不合法");
            return response;
        }

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        for(RoleInfoDto dto : request.getData()){
            Integer id = dto.getId();
            RoleInfoEntity entity = roleInfoMapper.queryRoleInfoById(id);
            if(entity == null){
                response.setCode("210000");
                response.setMsg("业务数据不合法");
                return response;
            }

            PoInfoEntity poInfoEntity = poInfoMapper.queryPoInfoById(dto.getPoId());
            dto.setBurnedManday(dto.getBurnedManday() + dto.getAccrueManday());
            poInfoEntity.setTotalBurnedManday(poInfoEntity.getTotalBurnedManday() + dto.getBurnedManday() - entity.getBurnedManday());
            poInfoEntity.setBalanceManday(poInfoEntity.getPoInitialTotalManday() - poInfoEntity.getTotalBurnedManday());
            poInfoEntity.setBilledAmtIn(poInfoEntity.getTotalBurnedManday() * entity.getRateIn() * (1 + poInfoEntity.getVat() * 0.01));
            poInfoEntity.setPoAvailableAmtIn(poInfoEntity.getPoTotalAmountIn() - poInfoEntity.getBilledAmtIn());

            RoleInfoEntity roleInfoEntity = new RoleInfoEntity();
            roleInfoEntity.setId(dto.getId());
            roleInfoEntity.setPoRole(dto.getPoRole());
            roleInfoEntity.setBillableManday(dto.getBillableManday());
            roleInfoEntity.setBurnedManday(dto.getBurnedManday());
            roleInfoEntity.setBalanceManday(dto.getBillableManday() - dto.getBurnedManday());
            roleInfoEntity.setTotalAmountIn(dto.getTotalAmount());
            roleInfoEntity.setBurnedAmountIn(dto.getBurnedManday() * dto.getRate());
            roleInfoEntity.setBalanceAmountIn(dto.getTotalAmount() - dto.getBurnedManday() * dto.getRate());
            roleInfoEntity.setRoleComment(dto.getRoleComment());
            roleInfoEntity.setLastupdateDate(timestamp);

            roleInfoMapper.updateRoleInfoById(roleInfoEntity);
            poInfoMapper.updatePoInfoEntity(poInfoEntity);
        }

        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }

   /* public CommonResponse updateRoleInfoAmountById(RoleInfoSaveRequest request){
        CommonResponse response = new CommonResponse();

        if(request.getData() == null || request.getData().size() == 0){
            response.setCode("210000");
            response.setMsg("请求数据不合法");
            return response;
        }

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        List<RoleInfoEntity> toDbs = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for(RoleInfoDto dto : request.getData()){
            RoleInfoEntity entity = new RoleInfoEntity();
            RoleInfoEntity db = roleInfoMapper.queryRoleInfoById(dto.getId());
            if(db == null){
                sb.append(dto.getPoRole() + "，项目不存在");
                sb.append(",");

                continue;
            }

            entity.setId(dto.getId());
            entity.setPoRole(dto.getPoRole());
            entity.setTotalAmount(dto.getTotalAmount());
            entity.setBurnedAmount(dto.getBurnedAmount());
            entity.setBalanceAmount(dto.getBalanceAmount());
            entity.setCreateDate(timestamp);
            entity.setLastupdateDate(timestamp);
            entity.setRate(dto.getRate());
            entity.setBillableManday(dto.getBillableManday());
            entity.setBurnedManday(dto.getBurnedManday());
            entity.setBalanceManday(dto.getBalanceManday());
            entity.setRoleComment(dto.getRoleComment());
            toDbs.add(entity);
        }

        if(sb.length() > 0){
            response.setCode("200001");
            response.setMsg(sb.substring(0, sb.length()-1));
            return response;
        }

        for(RoleInfoEntity entity : toDbs){
            roleInfoMapper.updateRoleInfoById(entity);
        }

        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }*/

    public CommonResponse deleteRoleInfoById(Integer id){
        CommonResponse response = new CommonResponse();

        List<ConInfoEntity> conInfoEntityList = conInfoMapper.queryConInfoByRoleId(id);
        if(conInfoEntityList.size() != 0){
            response.setCode("220000");
            response.setMsg("There are consulants in this role!");
            return response;
        }

        roleInfoMapper.deleteRoleInfoById(id);

        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }

    public List<RoleInfoDto> viewRoleInfoByPoId(Integer poId){
        List<RoleInfoDto> dtos = new ArrayList<>();

        List<RoleInfoEntity> entityList = roleInfoMapper.queryRoleInfoByPoId(poId);
        for (RoleInfoEntity entity : entityList){
            dtos.add(roleInfoEntity2Dto(entity));
        }

        return dtos;
    }

    private RoleInfoDto roleInfoEntity2Dto(RoleInfoEntity entity){
        if(entity == null){
            return null;
        }

        RoleInfoDto dto = new RoleInfoDto();

        dto.setId(entity.getId());
        dto.setPoRole(entity.getPoRole());
        dto.setTotalAmount(entity.getTotalAmountIn());
        dto.setBurnedAmount(entity.getBurnedAmountIn());
        dto.setBalanceAmount(entity.getBalanceAmountIn());
        dto.setCreateDate(DateUtil.timestamp2yyyyMMdd(entity.getCreateDate()));
        dto.setLastupdateDate(DateUtil.timestamp2yyyyMMdd(entity.getLastupdateDate()));
        dto.setPoId(entity.getPoId());
        dto.setBillableManday(entity.getBillableManday());
        dto.setBurnedManday(entity.getBurnedManday());
        dto.setBalanceManday(entity.getBalanceManday());
        dto.setRate(entity.getRateIn());
        dto.setRoleComment(entity.getRoleComment());

        return dto;
    }

}
