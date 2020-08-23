package com.xl.xlblog.service.userservice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xl.xlblog.mapper.LeaveMessageDao;
import com.xl.xlblog.pojo.LeaveMessage;
import com.xl.xlblog.pojo.Result;
import com.xl.xlblog.pojo.User;
import com.xl.xlblog.service.userservice.LeaveMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/15
 * @Time 19:35
 */
@Service
public class LeaveMessageServiceImpl implements LeaveMessageService {

    @Autowired
    LeaveMessageDao leaveMessageDao;

    @Value("${comment.avatar}")
    private String avatar;

    @Override
    public List<LeaveMessage> pageSelectLeaveMessage() {
        List<LeaveMessage> leaveMessages = leaveMessageDao.selectAllParLeaveMessage();
        if (leaveMessages!=null && leaveMessages.size()>0){
            for (int i = 0; i < leaveMessages.size(); i++) {
                List<LeaveMessage> childLeaveMessages = leaveMessageDao.selectChildLeaveMessageByParLeaveMessage(leaveMessages.get(i).getId());
                 leaveMessages.get(i).setChildLeaveMessage(childLeaveMessages);
            }
        }
        return leaveMessages;
    }

    @Override
    public Result insertLeaveMessage(LeaveMessage leaveMessage, HttpSession session) {
        Result result = new Result();
        if (leaveMessage == null){
            result.setCode(0);
            result.setMessage("评论失败!");
            return result;
        }
        //判断是不是一级留言
        if (leaveMessage.getParLeaveMessageId()>0){
            //不是一级留言
            leaveMessage.setLevel(false);
        }else {
            leaveMessage.setLevel(true);
        }
        //如果是博主评论
        if (session.getAttribute("user") != null){
            User user = (User)session.getAttribute("user");
            leaveMessage.setHeadImg(user.getHeadImg());
            leaveMessage.setNickName(user.getNickName());
            leaveMessage.setEmail(user.getEmail());
            leaveMessage.setAdmin(true);
        }else {
            leaveMessage.setHeadImg(avatar);
        }
        int i = leaveMessageDao.insertLeaveMessage(leaveMessage);
        if (i==1){
            result.setCode(1);
            result.setMessage("评论成功!");
        }else {
            result.setCode(0);
            result.setMessage("评论失败!");
        }
        return result;
    }

    @Override
    public Result deleteLeaveMessage(Long id) {
        Result result = new Result();
        if (id <= 0){
            result.setCode(0);
            result.setMessage("删除失败!");
            return result;
        }
        int i = leaveMessageDao.delLeaveMessage(id);
        if (i != 0){
            result.setCode(1);
            result.setMessage("删除成功!");
        }else {
            result.setCode(0);
            result.setMessage("删除失败!");
        }
        return result;
    }
}
