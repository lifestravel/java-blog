package com.xl.xlblog.service.userservice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xl.xlblog.mapper.TypeDao;
import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.pojo.Type;
import com.xl.xlblog.service.userservice.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/14
 * @Time 14:19
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeDao typeDao;

    @Override
    public List<Type> selectAllType() {
        return typeDao.selectAllType();
    }

    @Override
    public PageInfo<Blog> pageSelectBlogByType(int currentPage,int pageSize,Long typeId) {
        PageHelper.startPage(currentPage,pageSize);
        List<Blog> blogs = typeDao.pageSelectBlogByType(typeId);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        return pageInfo;
    }
}
