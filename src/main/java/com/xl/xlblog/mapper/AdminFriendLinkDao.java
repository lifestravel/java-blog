package com.xl.xlblog.mapper;

import com.xl.xlblog.pojo.FriendLink;
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
public interface AdminFriendLinkDao {

    /**
     * 分页查询右脸
     * @return
     */
   List<FriendLink> pageSelectFriendLink();

    /***
     * 添加友链
     * @param friendLink
     * @return
     */
   int addFriendLink(FriendLink friendLink);

    /**
     *
     * 编辑友链
     * @param friendLink
     * @return
     */
   int editFriendLink(FriendLink friendLink);

    /**
     * 根据友链id删除友链
     * @param id
     * @return
     */
   int delFriendLinkById(@Param("id") Long id);

    /**
     * 根据id查询友链
     * @param id
     * @return
     */
   FriendLink selectFriendLinkById(@Param("id") Long id);

    /**
     * 根据url查询友链，主要是防止添加重复的友链
     * @param url
     * @return
     */
   int selectFriendLinkByURL(@Param("url") String url);
}
