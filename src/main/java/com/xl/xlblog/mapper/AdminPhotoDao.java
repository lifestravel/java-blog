package com.xl.xlblog.mapper;

import com.xl.xlblog.pojo.FriendLink;
import com.xl.xlblog.pojo.Photo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/13
 * @Time 11:26
 */
@Mapper
@Repository
public interface AdminPhotoDao {

    /**
     * 分页查询相册
     * @return
     */
    List<Photo> pageSelectPhoto();

    /**
     * 添加相册
     * @param photo
     * @return
     */
    int addPhoto(Photo photo);


    /**
     * 编辑相册
     * @param photo
     * @return
     */
    int editPhoto(Photo photo);

    /**
     * 根据id删除相片
     * @param id
     * @return
     */
    int delPhotoById(@Param("id") Long id);


    /**
     * 根据id查询相片
     * @param id
     * @return
     */
    Photo selectPhotoById(@Param("id") Long id);
}
