package com.xl.xlblog.service.userservice;

import com.xl.xlblog.pojo.FriendLink;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/15
 * @Time 13:38
 */
public interface FriendLinkService {

    /**
     * 查询所有的友链
     * @return
     */
   List<FriendLink> selectAllFriendLink();
}
