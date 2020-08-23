package com.xl.xlblog.mapper;

import com.xl.xlblog.pojo.LeaveMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/15
 * @Time 15:16
 */
@Mapper
@Repository
public interface LeaveMessageDao {

    /**
     * 分页查询父留言
     * @return
     */
    List<LeaveMessage> selectAllParLeaveMessage();

    /**
     * 根据父评论id查询子留言
     * @param parLeaveMessageId
     * @return
     */
    List<LeaveMessage> selectChildLeaveMessageByParLeaveMessage(@Param("parLeaveMessageId") Long parLeaveMessageId);

    /**
     * 添加留言
     * @param leaveMessage
     * @return
     */
    int insertLeaveMessage(LeaveMessage leaveMessage);

    /**
     * 根据id删除留言
     * @param id
     * @return
     */
    int delLeaveMessage(@Param("id") Long id);
}
