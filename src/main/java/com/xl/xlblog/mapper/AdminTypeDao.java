package com.xl.xlblog.mapper;

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
 * @Date 2020/8/2
 * @Time 17:51
 */
@Mapper
@Repository
public interface AdminTypeDao {
    /**
     * 根据名字查询是由已有分类
     * @param name
     * @return
     */
    Type selectTypeByName(String name);

    /**
     * 新增分类
     * @param name
     * @return
     */
    int addType(@Param("name") String name);

    /**
     * 编辑类型
     * @param type
     * @return
     */
    int editType(Type type);

    /**
     * 删除类型
     * @param id
     * @return
     */
    int delType(@Param("id") int id);

    /**
     * 分页查询
     * @return
     */
    List<Type> pageSelect();


    /**
     * 查询所有分类
     * @return
     */
    List<Type> selectAll();


    /**
     * 根据博客id查询type
     * @param id
     * @return
     */
    Type selectTypeByBlogId(@Param("id") Long id);

    /**
     * 查询该type下的所有分类
     * @param id
     * @return
     */
    List<Long> selBlogIdByType(@Param("typeId") int id);

    /**
     * 根据typeId从博客类型表中删除记录
     * @param id
     */
    void delBlogTypeByTypeId(@Param("typeId") int id);
}
