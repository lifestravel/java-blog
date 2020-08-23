package com.xl.xlblog.service.userservice.impl;

import com.xl.xlblog.mapper.PhotoDao;
import com.xl.xlblog.pojo.Photo;
import com.xl.xlblog.service.userservice.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/15
 * @Time 14:32
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoDao photoDao;

    @Override
    public List<Photo> selectAllPhoto() {
        return photoDao.selectAllPhoto();
    }
}
