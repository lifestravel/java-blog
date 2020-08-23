package com.xl.xlblog.service.adminservice;

import com.github.pagehelper.PageInfo;
import com.xl.xlblog.pojo.FriendLink;
import com.xl.xlblog.pojo.Result;
import org.apache.ibatis.annotations.Param;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/13
 * @Time 12:05
 */
public interface AdminFriendLinkService {

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<FriendLink> pageSelectFriendLink(int currentPage,int pageSize);

    /**
     * 添加友链
     * @param friendLink
     * @return
     */
    Result addFriendLink(FriendLink friendLink);

    /**
     *
     * 编辑友链
     * @param friendLink
     * @return
     */
    Result editFriendLink(FriendLink friendLink);

    /**
     * 根据友链id删除友链
     * @param id
     * @return
     */
    Result delFriendLinkById(Long id);

    /**
     * 根据id查询友链
     * @param id
     * @return
     */
    FriendLink selectFriendLinkById(Long id);
}
