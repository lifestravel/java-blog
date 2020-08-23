package com.xl.xlblog.service.userservice;

import com.xl.xlblog.pojo.Blog;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/9
 * @Time 14:09
 */
public interface BlogDetailsService {

    /**
     * 根据博客id查询博客详情
     * @param id
     * @return
     */
    Blog selectBlogDetails(Long id);
}
