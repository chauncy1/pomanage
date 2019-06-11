package com.capgemini.service;

import com.capgemini.dto.PoInfoDto;
import com.capgemini.dto.request.PoSaveRequest;
import com.capgemini.dto.response.CommonResponse;
import com.capgemini.dto.response.PoQueryResponse;
import com.capgemini.entity.PoInfoEntity;
import com.capgemini.mapper.PoInfoMapper;
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
public class UserManagementService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserManagementService.class);

   
}
