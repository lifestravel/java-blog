package com.xl.xlblog.service.userservice.impl;

import com.xl.xlblog.mapper.WebSiteInfoDao;
import com.xl.xlblog.pojo.WebSiteInfo;
import com.xl.xlblog.service.userservice.WebSiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/16
 * @Time 12:19
 */
@Service
public class WebSiteInfoServiceImpl implements WebSiteInfoService {

    @Autowired
    WebSiteInfoDao webSiteInfoDao;

    @Override
    public WebSiteInfo selectWebsiteInfo() {
        return webSiteInfoDao.selectWebSiteInfo();
    }
}
