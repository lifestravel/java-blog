package com.xl.xlblog.mapper;

import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/14
 * @Time 14:20
 */
@Mapper
@Repository
public interface TypeDao {

    /**
     * 查询所有的类型
     * @returnv
     */
    List<Type> selectAllType();


    /**
     * 根据类型分页查询博客
     * @param typeId
     * @return
     */
    List<Blog> pageSelectBlogByType(@Param("typeId") Long typeId);
}
