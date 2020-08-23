package com.xl.xlblog.mapper;

import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.pojo.BlogList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/5
 * @Time 18:06
 */
@Mapper
@Repository
public interface AdminBlogDao {


    /**
     * 添加博客
     * @param blog
     * @return
     */
    int addBlog(Blog blog);


    /**
     * 在博客类型表中插入关联记录
     * @param blogId
     * @param typeId
     * @return
     */
    int addBlog_Type(@Param("blogId") Long blogId,@Param("typeId") Long typeId);


    /**
     * 分页查询
     * @param title
     * @param typeName
     * @param recommended
     * @return
     */
    List<BlogList> pageSelectBlog(@Param("title") String title, @Param("typeName") String typeName, @Param("recommended") boolean recommended);

    /**
     * 删除博客
     * @param id
     * @return
     */
    int delBlog(@Param("id") long id);


    /**
     * 从博客类型表中删除关联记录
     * @param id
     * @return
     */
    int delBlogType(@Param("id") Long id);


    /**
     * 根据id查询博客
     * @param id
     * @return
     */
    Blog selectBlogById(@Param("id") Long id);

    /**
     * 修改博客
     * @param blog
     * @return
     */
    int editBlog(Blog blog);

    /**
     * 修改博客类型
     * @param id
     * @param typeId
     */
    void editBlog_Type(@Param("id") Long id,@Param("typeId") long typeId);

    /**
     * 在用户博客表添加记录
     * @param id
     * @param userId
     * @return
     */
    int addUsr_blog(@Param("blogId") Long id, @Param("userId") Long userId);

    /**
     * 从用户博客表删除记录
     * @param id
     * @return
     */
    int delUser_Blog(@Param("blogId") Long id);

    /**
     * 删除博客下面的所有评论
     * @param id
     * @return
     */
    int delCommentByBlogId(@Param("blogId") Long id);

    /**
     * 设置该type下的文章数量+1
     * @param typeId
     * @return
     */
    int AddBlogCountByType(@Param("typeId") Long typeId);

    /**
     * 设置该类型下的文章数量-1
     * @param id
     * @return
     */
    int decBlogCountByType(@Param("blogId") Long id);
}
