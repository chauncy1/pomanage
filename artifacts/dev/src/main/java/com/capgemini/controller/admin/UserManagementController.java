package com.capgemini.controller.admin;

import com.capgemini.dto.request.PoSaveRequest;
import com.capgemini.dto.request.RoleInfoSaveRequest;
import com.capgemini.dto.response.CommonResponse;
import com.capgemini.dto.response.PoQueryResponse;
import com.capgemini.dto.response.RoleInfoQueryResponse;
import com.capgemini.service.PoInfoService;
import com.capgemini.service.RoleInfoService;
import com.capgemini.service.UserManagementService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/admin-user-mgmt")
public class UserManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagementController.class);
    @Autowired
    private UserManagementService userManagementService;
}