package com.xl.xlblog.service.adminservice;

import com.xl.xlblog.pojo.Result;
import com.xl.xlblog.pojo.Type;
import org.apache.ibatis.annotations.Param;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/3
 * @Time 15:53
 */
public interface AdminTypeService {


    /**
     * 新增分类
     * @param name
     * @return
     */
    int addType(String name);


    /**
     * 删除分类
     * @param id
     * @return
     */
    int delType(int id);

    /**
     * 编辑分类
     * @param type
     * @return
     */
    int editType(Type type);

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    Result pageSelect(int currentPage, int pageSize);


    /**
     * 查询所有分类
     * @return
     */
    Result selectAll();

    /**
     * 根据博客id查询type
     * @param id
     * @return
     */
    Type selectTypeByBlogId(Long id);

}
