package com.xl.xlblog.service.adminservice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xl.xlblog.mapper.AdminPhotoDao;
import com.xl.xlblog.pojo.Photo;
import com.xl.xlblog.pojo.Result;
import com.xl.xlblog.service.adminservice.AdminPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/13
 * @Time 12:06
 */
@Service
public class AdminAdminPhotoServiceImpl implements AdminPhotoService {

    @Autowired
    AdminPhotoDao adminPhotoDao;

    @Override
    public PageInfo<Photo> pageSelectPhoto(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Photo> photos = adminPhotoDao.pageSelectPhoto();
        PageInfo<Photo> pageInfo = new PageInfo<>(photos);
        return pageInfo;
    }

    @Override
    public Result addPhoto(Photo photo) {
        Result result = new Result();
        if (photo == null) {
            result.setCode(0);
            result.setMessage("添加失败!");
            return result;
        }
        int i = adminPhotoDao.addPhoto(photo);
        if (i == 1) {
            result.setCode(1);
            result.setMessage("添加成功!");
        } else {
            result.setCode(0);
            result.setMessage("添加失败!");
        }
        return result;
    }

    @Override
    public Result editPhoto(Photo photo) {
        Result result = new Result();
        if (photo == null) {
            result.setCode(0);
            result.setMessage("添加失败!");
            return result;
        }
        int i = adminPhotoDao.editPhoto(photo);
        if (i == 1) {
            result.setCode(1);
            result.setMessage("修改成功!");
        } else {
            result.setCode(0);
            result.setMessage("修改失败!");
        }
        return result;
    }

    @Override
    public Result delPhotoById(Long id) {
        Result result = new Result();
        if (id <= 0) {
            result.setCode(0);
            result.setMessage("删除失败!");
            return result;
        }
        int i = adminPhotoDao.delPhotoById(id);
        if (i == 1) {
            result.setCode(1);
            result.setMessage("删除成功!");
        } else {
            result.setCode(0);
            result.setMessage("删除失败!");
        }
        return result;
    }

    @Override
    public Photo selectPhotoById(Long id) {
        return adminPhotoDao.selectPhotoById(id);
    }
}
