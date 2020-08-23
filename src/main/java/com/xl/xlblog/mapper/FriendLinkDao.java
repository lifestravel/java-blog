package com.xl.xlblog.mapper;

import com.xl.xlblog.pojo.FriendLink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/15
 * @Time 13:33
 */
@Mapper
@Repository
public interface FriendLinkDao {

    /**
     * 查询所有的友链
     * @return
     */
    List<FriendLink> selectAllFriendLink();
}
