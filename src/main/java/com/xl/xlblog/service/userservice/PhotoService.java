package com.xl.xlblog.service.userservice;

import com.xl.xlblog.pojo.Photo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/15
 * @Time 14:31
 */
public interface PhotoService {

    /**
     * 查询所有照片
     * @return
     */
    List<Photo> selectAllPhoto();
}
