package com.xl.xlblog.service.adminservice.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xl.xlblog.mapper.AdminBlogDao;
import com.xl.xlblog.mapper.AdminTypeDao;
import com.xl.xlblog.pojo.Result;
import com.xl.xlblog.pojo.Type;

import com.xl.xlblog.service.adminservice.AdminBlogService;
import com.xl.xlblog.service.adminservice.AdminTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/2
 * @Time 17:47
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AdminAdminTypeServiceImpl implements AdminTypeService {

    @Autowired
    AdminTypeDao adminTypeDao;

    @Autowired
    AdminBlogDao adminBlogDao;

    @Override
    public int addType(String name) {
        if (StringUtils.isEmpty(name)){
            return -1;
        }else {
            Type type = adminTypeDao.selectTypeByName(name);
            if (type != null) {
                return 0;
            } else {
                return adminTypeDao.addType(name);
            }
        }
    }

    @Override
    public int delType(int id) {
        if (id > 0) {
            List<Long> list = adminTypeDao.selBlogIdByType(id);
            if(list !=null && list.size()>0){
                for (Long blogId: list) {
                    int j = adminBlogDao.delUser_Blog(blogId);
                    int z = adminBlogDao.delBlog(blogId);
                    int c = adminBlogDao.delCommentByBlogId(blogId);
                }
            }
             adminTypeDao.delBlogTypeByTypeId(id);
            return adminTypeDao.delType(id);
        } else {
            return 0;
        }
    }

    @Override
    public int editType(Type type) {
        if (type != null) {
            Type type1 = adminTypeDao.selectTypeByName(type.getName());
            if (type1 !=null) {
                return 0;
            }else {
                return adminTypeDao.editType(type);
            }
        } else {
            return 0;
        }
    }

    @Override
    public Result pageSelect(int currentPage, int pageSize) {
        Result result = new Result();
        PageHelper.startPage(currentPage,pageSize);
        List<Type> pages = adminTypeDao.pageSelect();
        if ( pages!=null&& pages.size()!=0){
            result.setCode(1);
            PageInfo<Type> pageInfo = new PageInfo<>(pages);
            System.out.println(pageInfo.getList());
            result.setObject(pageInfo);
        }else {
            result.setCode(0);
            result.setMessage("暂时没有任何数据!");
        }
        return result;
    }

    @Override
    public Result selectAll() {
        Result result = new Result();
        List<Type> types = adminTypeDao.selectAll();
        if (types!= null && types.size()>0){
            result.setCode(1);
            result.setObject(types);
        }else {
            result.setCode(0);
            result.setMessage("没有查询到分类");
        }
        return result;
    }

    @Override
    public Type selectTypeByBlogId(Long id) {
        return adminTypeDao.selectTypeByBlogId(id);
    }
}
