package com.xl.xlblog.service.userservice;

import com.xl.xlblog.mapper.TimestampDao;
import com.xl.xlblog.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/14
 * @Time 20:17
 */
public interface TimestampService {

    /**
     * 查询时间戳
     * @return
     */
    List<Blog> getTimestamp();

}
