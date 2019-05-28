package com.capgemini.service;


import com.capgemini.dto.ExpiringPoInfoDto;
import com.capgemini.dto.PoInfoDto;
import com.capgemini.dto.ProjectInfoDto;
import com.capgemini.dto.request.PoSaveRequest;
import com.capgemini.dto.response.CommonResponse;
import com.capgemini.dto.response.PoQueryResponse;
import com.capgemini.entity.PoInfoEntity;
import com.capgemini.entity.ProjectInfoEntity;
import com.capgemini.entity.RoleInfoEntity;
import com.capgemini.mapper.PoInfoMapper;
import com.capgemini.mapper.ProjectInfoMapper;
import com.capgemini.mapper.RoleInfoMapper;
import com.capgemini.utils.DateUtil;

import org.apache.poi.xwpf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zexuan.jin@capgemini.com(Jason)
 * @date 17/11/2018 2:33 AM
 * @description
 */

@Service
@Transactional
public class PoInfoService {

    private final static Logger logger = LoggerFactory.getLogger(PoInfoService.class);

    @Autowired
    private PoInfoMapper poInfoMapper;

    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    /**
     * 将参数ID对应的PO信息组装成Word返回到Controller导出
     */
    public XWPFDocument exportPoInfo(Integer id) {

        //根据ID查询PO信息
        PoInfoEntity poEntity = poInfoMapper.queryPoInfoById(id);
        XWPFDocument document = null;
        try {
            InputStream inputStream = new FileInputStream("C:/Users/yliu12/Desktop/po_template.docx");
            document = new XWPFDocument(inputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //遍历并选取Career表格
        List<XWPFTable> tables = document.getTables();
        XWPFTable table = tables.get(0);

        //插入数据
        //设置时间转换格式
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<XWPFTableRow> rows = table.getRows();
        //第一行插入合同名称
        XWPFTableRow nameRow = rows.get(0);
        XWPFRun nameRun = nameRow.getCell(0).getParagraphArray(0).createRun();
        nameRun.setText(poEntity.getPoName());
        //第二行插入项目编号
        XWPFTableRow codeRow = rows.get(1);
        XWPFRun codeRun = codeRow.getCell(1).getParagraphArray(0).createRun();
        codeRun.setText(poEntity.getCode());
        //第三行插入合同编码
        XWPFTableRow poNoRow = rows.get(2);
        XWPFRun poNoRun = poNoRow.getCell(1).getParagraphArray(0).createRun();
        poNoRun.setText(poEntity.getPoNo());
        //第四行插入合同开始日期
        XWPFTableRow startRow = rows.get(3);
        XWPFRun startRun = startRow.getCell(1).getParagraphArray(0).createRun();
        startRun.setText(sdf.format(poEntity.getStartDate()));
        //第五行插入合同结束日期
        XWPFTableRow endRow = rows.get(4);
        XWPFRun endRun = endRow.getCell(1).getParagraphArray(0).createRun();
        endRun.setText(sdf.format(poEntity.getEndDate()));
        //第六行插入合同描述
        XWPFTableRow descRow = rows.get(5);
        XWPFRun descRun = descRow.getCell(1).getParagraphArray(0).createRun();
        descRun.setText(poEntity.getPoDesc());
        //第七行插入合同类型
        XWPFTableRow typeRow = rows.get(6);
        XWPFRun typeRun = typeRow.getCell(1).getParagraphArray(0).createRun();
        typeRun.setText(poEntity.getContentType());
        //第八行插入合同状态
        XWPFTableRow statusRow = rows.get(7);
        XWPFRun statusRun = statusRow.getCell(1).getParagraphArray(0).createRun();
        statusRun.setText(poEntity.getPoStatus());
        //第九行插入合同总人天
        XWPFTableRow totalMandayRow = rows.get(8);
        XWPFRun totalMandayRun = totalMandayRow.getCell(1).getParagraphArray(0).createRun();
        totalMandayRun.setText(String.valueOf(poEntity.getPoInitialTotalManday()));
        //第十行插入合同总金额（不含税）
        XWPFTableRow totalAmountExRow = rows.get(9);
        XWPFRun totalAmountExRun = totalAmountExRow.getCell(1).getParagraphArray(0).createRun();
        totalAmountExRun.setText(String.valueOf(poEntity.getPoTotalAmountEx()));
        //第十一行插入合同总金额（含税）
        XWPFTableRow totalAmountInRow = rows.get(10);
        XWPFRun totalAmountInRun = totalAmountInRow.getCell(1).getParagraphArray(0).createRun();
        totalAmountInRun.setText(String.valueOf(poEntity.getPoTotalAmountIn()));
        //第十二行插入合同已使用金额（含税）
        XWPFTableRow burnedAmountRow = rows.get(11);
        XWPFRun burnedAmountRun = burnedAmountRow.getCell(1).getParagraphArray(0).createRun();
        burnedAmountRun.setText(String.valueOf(poEntity.getBilledAmtIn()));
        //第十三行插入合同可用金额（含税）
        XWPFTableRow availableAmountRow = rows.get(12);
        XWPFRun availableAmountRun = availableAmountRow.getCell(1).getParagraphArray(0).createRun();
        availableAmountRun.setText(String.valueOf(poEntity.getPoAvailableAmtIn()));
        //第十四行插入合同已用人天
        XWPFTableRow burnedMandayRow = rows.get(13);
        XWPFRun burnedMandayRun = burnedMandayRow.getCell(1).getParagraphArray(0).createRun();
        burnedMandayRun.setText(String.valueOf(poEntity.getTotalBurnedManday()));
        //第十五行插入合同剩余人天
        XWPFTableRow balanceMandayRow = rows.get(14);
        XWPFRun balanceMandayRun = balanceMandayRow.getCell(1).getParagraphArray(0).createRun();
        balanceMandayRun.setText(String.valueOf(poEntity.getBalanceManday()));
        //第十六行插入税率
        XWPFTableRow vatRow = rows.get(15);
        XWPFRun vatRun = vatRow.getCell(1).getParagraphArray(0).createRun();
        vatRun.setText(String.valueOf(poEntity.getVat()));
        //第十七行插入备注
        XWPFTableRow remarkRow = rows.get(16);
        XWPFRun remarkRun = remarkRow.getCell(1).getParagraphArray(0).createRun();
        remarkRun.setText(poEntity.getPoComment());

        return document;

    }


    /**
     * 查询即将到期的PO
     */
    public List<ExpiringPoInfoDto> listExpiringPo() {
        List<ExpiringPoInfoDto> expiringPoInfoDtoList = new ArrayList<ExpiringPoInfoDto>();
        List<PoInfoEntity> poInfoEntityList = poInfoMapper.queryPoInfos();
        for (PoInfoEntity poInfoEntity : poInfoEntityList) {
            ExpiringPoInfoDto expiringPoInfoDto = new ExpiringPoInfoDto();
            Date currentDate = new Date();
            Date endDate = poInfoEntity.getEndDate();
            Integer remainingDays = (int) ((endDate.getTime() - currentDate.getTime())/86400000);
            if (remainingDays <= 0 || remainingDays > 7) {
                continue;
            }

            expiringPoInfoDto.setCode(poInfoEntity.getCode());
            expiringPoInfoDto.setPoNo(poInfoEntity.getPoNo());
            expiringPoInfoDto.setPoName(poInfoEntity.getPoName());
            expiringPoInfoDto.setRemainingDays((remainingDays));
            expiringPoInfoDtoList.add(expiringPoInfoDto);

        }

        return  expiringPoInfoDtoList;
    }

    @Transactional
    public CommonResponse savePoInfo(@RequestBody PoSaveRequest request){
        CommonResponse response = new CommonResponse();

        if(request.getData() == null || request.getData().size() == 0){
            response.setCode("210000");
            response.setMsg("请求数据不合法");
            return response;
        }

        Integer count = 0;

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        List<PoInfoEntity> toDbs = new ArrayList<>();
        loop1: for(PoInfoDto dto : request.getData()){

            List<PoInfoEntity> poInfoEntities = poInfoMapper.queryPoInfosByCode(dto.getCode());
            for(PoInfoEntity poInfoEntity : poInfoEntities){
                if(dto.getPoNo().equals(poInfoEntity.getPoNo())){
                    count++;
                    continue loop1;
                }
            }

            PoInfoEntity entity = new PoInfoEntity();
            entity.setId(dto.getId());
            entity.setCode(dto.getCode());
            entity.setPoName(dto.getPoName());
            entity.setStartDate(DateUtil.yyyyMMdd2timestamp(dto.getStartDate()));
            entity.setEndDate(DateUtil.yyyyMMdd2timestamp(dto.getEndDate()));
            entity.setCreateDate(timestamp);
            entity.setLastupdateDate(timestamp);
            entity.setPoNo(dto.getPoNo());
            entity.setPoDesc(dto.getPoDesc());
            entity.setPoStatus(dto.getPoStatus());
            entity.setPoInitialTotalManday(dto.getPoInitialTotalManday());
            entity.setPoTotalAmountEx(dto.getPoTotalAmountEx());
            entity.setPoTotalAmountIn(dto.getPoTotalAmountIn());
            entity.setBilledAmtIn(dto.getBilledAmtIn());
            entity.setPoAvailableAmtIn(dto.getPoAvailableAmtIn());
            entity.setTotalBurnedManday(dto.getTotalBurnedManday());
            entity.setBalanceManday(dto.getBalanceManday());
            entity.setContentType(dto.getContentType());
            entity.setVat(dto.getVat());
            entity.setPoComment(dto.getPoComment());
            toDbs.add(entity);
        }

        if(count > 0){
            response.setCode("200001");
            response.setMsg("已存在PO");
            return response;
        }

        for(PoInfoEntity entity : toDbs){
            poInfoMapper.savePoInfoEntity(entity);
        }

        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }

    public CommonResponse updatePoInfo(PoSaveRequest request){
        CommonResponse response = new CommonResponse();

        if(request.getData() == null || request.getData().size() == 0){
            response.setCode("210000");
            response.setMsg("请求数据不合法");
            return response;
        }

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        List<PoInfoEntity> toDbs = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for(PoInfoDto dto : request.getData()){
            PoInfoEntity entity = new PoInfoEntity();
//            System.out.println(dto.getPoNo());
            System.out.println(dto.getContentType());
            PoInfoEntity db = poInfoMapper.queryPoInfoByPoNo(dto.getPoNo());
//            System.out.println(db.getPoNo());
            if(db == null){
                sb.append(dto.getCode() + "，项目不存在");
                sb.append(",");

                continue;
            }

            entity.setId(dto.getId());
            entity.setCode(dto.getCode());
            entity.setPoName(dto.getPoName());
            entity.setStartDate(DateUtil.yyyyMMdd2timestamp(dto.getStartDate()));
            entity.setEndDate(DateUtil.yyyyMMdd2timestamp(dto.getEndDate()));
            entity.setCreateDate(DateUtil.yyyyMMdd2timestamp(dto.getCreateDate()));
            entity.setLastupdateDate(timestamp);
            entity.setPoNo(dto.getPoNo());
            entity.setPoDesc(dto.getPoDesc());
            entity.setPoStatus(dto.getPoStatus());
            entity.setPoInitialTotalManday(dto.getPoInitialTotalManday());
            entity.setPoTotalAmountEx(dto.getPoTotalAmountEx());
            entity.setPoTotalAmountIn(dto.getPoTotalAmountIn());
            entity.setBilledAmtIn(dto.getBilledAmtIn());
            entity.setPoAvailableAmtIn(dto.getPoAvailableAmtIn());
            entity.setTotalBurnedManday(dto.getTotalBurnedManday());
            entity.setBalanceManday(dto.getBalanceManday());
            entity.setContentType(dto.getContentType());
            entity.setVat(dto.getVat());
            entity.setPoComment(dto.getPoComment());
            toDbs.add(entity);
        }

        if(sb.length() > 0){
            response.setCode("200001");
            response.setMsg(sb.substring(0, sb.length()-1));
            return response;
        }

        for(PoInfoEntity entity : toDbs){
            poInfoMapper.updatePoInfoEntity(entity);
        }

        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }

    public CommonResponse deletePoById(Integer id){
        CommonResponse response = new CommonResponse();

        PoInfoEntity entity = poInfoMapper.queryPoInfoById(id);
        if(entity == null){
            response.setCode("200001");
            response.setMsg("项目不存在");

            return response;
        }

        List<RoleInfoEntity> roleInfoEntities = roleInfoMapper.queryRoleInfoByPoId(id);
        if(roleInfoEntities.size() != 0){
            response.setCode("220000");
            response.setMsg("There are roles in this PO!");
            return response;
        }

        poInfoMapper.deletePoInfoById(id);


        response.setCode("200000");
        response.setMsg("OK");

        return response;
    }

    public PoQueryResponse queryPoByCode(String code){
        PoQueryResponse response = new PoQueryResponse();
        response.setCode("200000");
        response.setMsg("OK");

        List<PoInfoEntity> entityList = poInfoMapper.queryPoInfosByCode(code);
        List<PoInfoDto> dtos = new ArrayList<>();
        if(entityList != null && entityList.size() >0){
            for(PoInfoEntity entity : entityList){
                dtos.add(poEntity2Dto(entity));
            }
        }
        response.setData(dtos);
        return response;
    }

    public PoInfoDto queryPoById(Integer id){
        PoInfoEntity entity = poInfoMapper.queryPoInfoById(id);

        return poEntity2Dto(entity);
    }

    public List<PoInfoDto> viewPoByCode(String code){
        List<PoInfoDto> data = new ArrayList<>();

        List<PoInfoEntity> entityList = new ArrayList<>();
        if(code == null || "".equals(code.trim())){
            entityList = poInfoMapper.queryPoInfos();
        }else {
            entityList = poInfoMapper.queryPoInfosByCode(code);
        }

        if(entityList != null && entityList.size() >0){
            for(PoInfoEntity entity : entityList){
                data.add(poEntity2Dto(entity));
            }
        }
        return data;
    }


    private PoInfoDto poEntity2Dto(PoInfoEntity entity){
        if(entity == null){
            return null;
        }

        PoInfoDto dto = new PoInfoDto();

        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setPoName(entity.getPoName());
        dto.setStartDate(DateUtil.timestamp2yyyyMMdd(entity.getStartDate()));
        dto.setEndDate(DateUtil.timestamp2yyyyMMdd(entity.getEndDate()));
        dto.setCreateDate(DateUtil.timestamp2yyyyMMdd(entity.getCreateDate()));
        dto.setLastupdateDate(DateUtil.timestamp2yyyyMMdd(entity.getLastupdateDate()));
        dto.setPoNo(entity.getPoNo());
        dto.setPoDesc(entity.getPoDesc());
        dto.setPoStatus(entity.getPoStatus());
        dto.setPoInitialTotalManday(entity.getPoInitialTotalManday());
        dto.setPoTotalAmountEx(entity.getPoTotalAmountEx());
        dto.setPoTotalAmountIn(entity.getPoTotalAmountIn());
        dto.setBilledAmtIn(entity.getBilledAmtIn());
        dto.setPoAvailableAmtIn(entity.getPoAvailableAmtIn());
        dto.setTotalBurnedManday(entity.getTotalBurnedManday());
        dto.setBalanceManday(entity.getBalanceManday());
        dto.setContentType(entity.getContentType());
        dto.setVat(entity.getVat());
        dto.setPoComment(entity.getPoComment());

        return dto;
    }



}
