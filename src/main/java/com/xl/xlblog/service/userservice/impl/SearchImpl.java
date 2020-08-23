package com.xl.xlblog.service.userservice.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xl.xlblog.mapper.SearchDao;
import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.service.userservice.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/9
 * @Time 17:04
 */
@Service
public class SearchImpl implements SearchService {

    @Autowired
    SearchDao searchDao;

    @Override
    public PageInfo<Blog> pageSearch(int currentPage, int pageSize, String search) {
        if (StringUtils.isEmpty(search)){
            return new PageInfo<Blog>();
        }
        PageHelper.startPage(currentPage,pageSize);
        List<Blog> blogs = searchDao.pageSearch(search);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        return pageInfo;
    }
}
