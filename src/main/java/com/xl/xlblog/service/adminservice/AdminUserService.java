package com.xl.xlblog.service.adminservice;

import com.xl.xlblog.pojo.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/7/30
 * @Time 21:32
 */

public interface AdminUserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    User userLogin(String username,String password) throws UnsupportedEncodingException;

}
