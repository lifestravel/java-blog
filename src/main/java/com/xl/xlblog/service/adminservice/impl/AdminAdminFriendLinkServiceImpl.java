package com.xl.xlblog.service.adminservice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xl.xlblog.mapper.AdminFriendLinkDao;
import com.xl.xlblog.pojo.FriendLink;
import com.xl.xlblog.pojo.Result;
import com.xl.xlblog.service.adminservice.AdminFriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/13
 * @Time 12:06
 */

@Service
public class AdminAdminFriendLinkServiceImpl implements AdminFriendLinkService {
    @Autowired
    AdminFriendLinkDao adminFriendLinkDao;

    @Override
    public PageInfo<FriendLink> pageSelectFriendLink(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<FriendLink> friendLinks = adminFriendLinkDao.pageSelectFriendLink();
        PageInfo<FriendLink> pageInfo = new PageInfo<>(friendLinks);
        return pageInfo;
    }

    @Override
    public Result addFriendLink(FriendLink friendLink) {
        Result result = new Result();
        if (friendLink == null){
            result.setCode(0);
            result.setMessage("添加失败!");
            return result;
        }
        int isExist = adminFriendLinkDao.selectFriendLinkByURL(friendLink.getBlogAddress());
        if (isExist !=0 ){
            result.setCode(0);
            result.setMessage("该友链已经存在");
            return result;
        }
        int i = adminFriendLinkDao.addFriendLink(friendLink);
        if (i == 1){
            result.setCode(1);
            result.setMessage("添加成功!");
        }else {
            result.setCode(0);
            result.setMessage("添加失败!");
        }
        return result;
    }

    @Override
    public Result editFriendLink(FriendLink friendLink) {
        Result result = new Result();
        if (friendLink == null){
            result.setCode(0);
            result.setMessage("修改失败!");
            return result;
        }
        int i = adminFriendLinkDao.editFriendLink(friendLink);
        if (i == 1){
            result.setCode(1);
            result.setMessage("修改成功!");
        }else {
            result.setCode(0);
            result.setMessage("修改失败!");
        }
        return result;
    }

    @Override
    public Result delFriendLinkById(Long id) {
        Result result = new Result();
        if(id<=0){
            result.setCode(0);
            result.setMessage("删除失败!");
            return result;
        }
        int i = adminFriendLinkDao.delFriendLinkById(id);
        if (i == 1){
            result.setCode(1);
            result.setMessage("删除成功!");
        }else {
            result.setCode(0);
            result.setMessage("删除失败!");
        }
        return result;
    }

    @Override
    public FriendLink selectFriendLinkById(Long id) {
      return adminFriendLinkDao.selectFriendLinkById(id);
    }
}
