package com.xl.xlblog;

import com.github.pagehelper.PageHelper;
import com.xl.xlblog.mapper.IndexDao;
import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.pojo.Comment;

import com.xl.xlblog.service.adminservice.AdminTypeService;
import com.xl.xlblog.service.adminservice.AdminUserService;
import com.xl.xlblog.service.userservice.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
@Slf4j
class XlBlogApplicationTests {


    @Autowired
    AdminUserService adminUserService;

    @Autowired
    AdminTypeService adminTypeService;

    @Autowired
    IndexService indexService;

    @Test
    public  void main() {
    }



  @Autowired
  IndexDao indexDao;


    @Test
    public void test(){
        PageHelper.startPage(1,2);
        List<Blog> blogs = indexDao.latestBlog();
        System.out.println(blogs);
    }

    @Autowired
    Comment comment;

    @Test
    public void test2(){
        System.out.println(comment);
    }
}
