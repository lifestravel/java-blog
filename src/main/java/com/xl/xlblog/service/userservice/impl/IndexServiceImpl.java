package com.xl.xlblog.service.userservice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xl.xlblog.mapper.IndexDao;
import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.service.userservice.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/8
 * @Time 15:24
 */
@Service
public class IndexServiceImpl  implements IndexService {

    @Autowired
    IndexDao indexDao;

    @Override
    public List<Blog> latestRecommended() {
        return indexDao.latestRecommended();
    }

    @Override
    public PageInfo<Blog> latestBlog(int currentPage,int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Blog> blogs = indexDao.latestBlog();
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        return pageInfo;
    }
}
