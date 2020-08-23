package com.xl.xlblog.mapper;

import com.xl.xlblog.pojo.WebSiteInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/16
 * @Time 12:10
 */
@Mapper
@Repository
public interface WebSiteInfoDao {

    /**
     * 网站信息
     * @return
     */
    WebSiteInfo selectWebSiteInfo();

}
