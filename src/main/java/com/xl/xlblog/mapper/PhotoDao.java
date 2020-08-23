package com.xl.xlblog.mapper;

import com.xl.xlblog.pojo.Photo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/15
 * @Time 14:27
 */
@Mapper
@Repository
public interface PhotoDao {

    /**
     * 查询所有照片
     * @return
     */
    List<Photo>  selectAllPhoto();
}
