package com.xl.xlblog.service.userservice;

import com.xl.xlblog.pojo.WebSiteInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/16
 * @Time 12:18
 */
public interface WebSiteInfoService {

    /**
     * 查询网站信息
     * @return
     */
   WebSiteInfo selectWebsiteInfo();
}
