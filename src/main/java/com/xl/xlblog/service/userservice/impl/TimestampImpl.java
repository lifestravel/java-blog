package com.xl.xlblog.service.userservice.impl;

import com.xl.xlblog.mapper.TimestampDao;
import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.service.userservice.TimestampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/14
 * @Time 20:23
 */
@Service
public class TimestampImpl implements TimestampService {

    @Autowired
    TimestampDao timestampDao;
    @Override
    public List<Blog> getTimestamp() {
        return timestampDao.selectAllBlog();
    }
}
