package com.xl.xlblog.service.adminservice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xl.xlblog.mapper.AdminBlogDao;
import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.pojo.BlogList;
import com.xl.xlblog.pojo.Result;
import com.xl.xlblog.service.adminservice.AdminBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/5
 * @Time 18:05
 */
@Service
public class AdminAdminBlogServiceImpl implements AdminBlogService {

    @Autowired
    AdminBlogDao adminBlogDao;


    @Override
    public Result pageSelectBlog(int currentPage, int pageSize, String title, String typeName, boolean recommended) {
        Result result = new Result();
        PageHelper.startPage(currentPage, pageSize);
        List<BlogList> blogs = adminBlogDao.pageSelectBlog(title, typeName, recommended);
        if (blogs != null && blogs.size() > 0) {
            result.setCode(1);
            PageInfo<BlogList> pageInfo = new PageInfo<>(blogs);
            System.out.println(pageInfo.getList());
            pageInfo.getList().get(0).getTitle();
            result.setObject(pageInfo);
        } else {
            result.setCode(0);
            result.setMessage("没有查询到结果!");
        }
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result addBlog(Blog blog, Long typeId, Long userId) {
        Result result = new Result();
        if (blog != null && typeId > 0) {
            int i = adminBlogDao.addBlog(blog);
            int j = adminBlogDao.addBlog_Type(blog.getId(), typeId);
            int z = adminBlogDao.addUsr_blog(blog.getId(), userId);
            int k = adminBlogDao.AddBlogCountByType(typeId);
            if (i == 1 && j == 1 && z == 1 && k==1) {
                result.setCode(1);
                result.setMessage("插入成功!");
                return result;
            }
        }
        result.setCode(0);
        result.setMessage("插入失败!");
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delBlog(Long id) {
        Result result = new Result();
        if (id > 0) {
            int k = adminBlogDao.decBlogCountByType(id);
            int i = adminBlogDao.delBlogType(id);
            int j = adminBlogDao.delUser_Blog(id);
            int z = adminBlogDao.delBlog(id);
            int c = adminBlogDao.delCommentByBlogId(id);
            if (i == 1 && j == 1 && z == 1 ) {
                result.setCode(1);
                result.setMessage("删除成功!");
                return result;
            }
        }
        result.setCode(0);
        result.setMessage("删除失败!");
        return result;
    }

    @Override
    public Blog selectBlogById(Long id) {
        return adminBlogDao.selectBlogById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result editBlog(Blog blog, long typeId) {
        Result result = new Result();
        if (blog != null && typeId > 0) {
            int i = adminBlogDao.editBlog(blog);
            System.out.println(i);
            result.setCode(i);
            if (i == 1) {
                adminBlogDao.editBlog_Type(blog.getId(), typeId);
                result.setMessage("插入成功!");
            } else {
                result.setMessage("插入失败");
            }
        } else {
            result.setCode(0);
            result.setMessage("插入失败!");
        }
        return result;
    }
}
