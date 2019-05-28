package com.capgemini.mapper;


import com.capgemini.entity.UserInfoEntity;


public interface UserInfoMapper {

    UserInfoEntity queryUserInfoById(Integer id);
}