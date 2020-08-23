package com.xl.xlblog.mapper;

import com.xl.xlblog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/7/30
 * @Time 21:34
 */
@Mapper
@Repository
public interface AdminUserDao {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User userLogin(@Param("username") String username, @Param("password") String password);


    /**
     * 根据博客id查询用户
     * @param blogId
     * @return
     */
    User selectUserByBlogId(@Param("blogId") Long blogId);
}
