package com.xl.xlblog.service.userservice;

import com.github.pagehelper.PageInfo;
import com.xl.xlblog.pojo.LeaveMessage;
import com.xl.xlblog.pojo.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/15
 * @Time 19:35
 */
public interface LeaveMessageService {

    /**
     * 查询留言
     * @return
     */
    List<LeaveMessage> pageSelectLeaveMessage();

    /**
     * 添加留言
     * @param leaveMessage
     * @param session
     * @return
     */
    Result insertLeaveMessage(LeaveMessage leaveMessage, HttpSession session);

    /**
     * 删除留言
     * @param id
     * @return
     */
    Result deleteLeaveMessage(Long id);
}
