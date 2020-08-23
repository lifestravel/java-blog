package com.xl.xlblog.controller.usercontroller;

import com.xl.xlblog.pojo.WebSiteInfo;
import com.xl.xlblog.service.userservice.WebSiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/16
 * @Time 10:56
 */
@RestController
@RequestMapping("/info")
public class WebSiteInformationController {

    @Autowired
    WebSiteInfoService webSiteInfoService;

    @GetMapping("/websiteInfo")
    public WebSiteInfo getWebsiteInfo(){
        WebSiteInfo webSiteInfo = webSiteInfoService.selectWebsiteInfo();
        return webSiteInfo;
    }
}
