package com.xl.xlblog.service.adminservice.impl;

import com.alibaba.druid.util.StringUtils;
import com.xl.xlblog.mapper.AdminUserDao;
import com.xl.xlblog.pojo.User;
import com.xl.xlblog.service.adminservice.AdminUserService;
import com.xl.xlblog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/7/30
 * @Time 21:33
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AdminAdminUserServiceImpl implements AdminUserService {

    @Autowired
    AdminUserDao userDao;

    @Override
    public User userLogin(String username, String password) throws UnsupportedEncodingException {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return null;
        }else {
            password =MD5Utils.getEncryption(password);
           return userDao.userLogin(username, password);
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String encryption = MD5Utils.getEncryption("123456");
        System.out.println(encryption);
    }
}
