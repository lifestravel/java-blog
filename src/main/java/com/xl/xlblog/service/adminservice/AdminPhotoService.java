package com.xl.xlblog.service.adminservice;

import com.github.pagehelper.PageInfo;
import com.xl.xlblog.pojo.FriendLink;
import com.xl.xlblog.pojo.Photo;
import com.xl.xlblog.pojo.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/13
 * @Time 12:06
 */
public interface AdminPhotoService {

    /**
     * 分忧查询相册
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Photo> pageSelectPhoto(int currentPage, int pageSize);

    /**
     * 添加相册
     * @param photo
     * @return
     */
    Result addPhoto(Photo photo);


    /**
     * 编辑相册
     * @param photo
     * @return
     */
    Result editPhoto(Photo photo);

    /**
     * 根据id删除相片
     * @param id
     * @return
     */
    Result delPhotoById(Long id);


    /**
     * 根据id查询相片
     * @param id
     * @return
     */
    Photo selectPhotoById(Long id);
}
