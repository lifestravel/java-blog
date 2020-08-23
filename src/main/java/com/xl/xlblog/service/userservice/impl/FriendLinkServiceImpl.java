package com.xl.xlblog.service.userservice.impl;

import com.xl.xlblog.mapper.FriendLinkDao;
import com.xl.xlblog.pojo.FriendLink;
import com.xl.xlblog.service.userservice.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/15
 * @Time 13:39
 */
@Service
public class FriendLinkServiceImpl implements FriendLinkService {

    @Autowired
    FriendLinkDao friendLinkDao;

    @Override
    public List<FriendLink> selectAllFriendLink() {
       return friendLinkDao.selectAllFriendLink();
    }
}
