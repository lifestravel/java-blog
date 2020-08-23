package com.xl.xlblog.service.userservice.impl;

import com.xl.xlblog.exceptionHandler.NotFoundException;
import com.xl.xlblog.mapper.BlogDetailsDao;
import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.service.userservice.BlogDetailsService;
import com.xl.xlblog.utils.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/9
 * @Time 14:09
 */
@Service
public class BlogDetailsServiceImpl implements BlogDetailsService {

    @Autowired
    BlogDetailsDao blogDetailsDao;


    @Override
    public Blog selectBlogDetails(Long id) {
        blogDetailsDao.incrViewsByBlog(id);
        Blog  blogDetails =  blogDetailsDao.selectBlogDetails(id);
        if (blogDetails == null){
            throw new NotFoundException("该博客不存在!");
        }
        String content = MarkdownUtils.markdownToHtmlExtensions(blogDetails.getContent());
        blogDetails.setContent(content);
        return blogDetails;
    }
}
