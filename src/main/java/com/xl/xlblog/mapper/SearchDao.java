package com.xl.xlblog.mapper;

import com.xl.xlblog.pojo.Blog;
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
 * @Date 2020/8/9
 * @Time 16:59
 */
@Mapper
@Repository
public interface SearchDao {


    /**
     * 分页搜索
     * @param search
     * @return
     */
   List<Blog> pageSearch(@Param("search") String search);

}
