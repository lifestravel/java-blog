package com.xl.xlblog.controller.usercontroller;

import com.github.pagehelper.PageInfo;
import com.xl.xlblog.pojo.Comment;
import com.xl.xlblog.pojo.LeaveMessage;
import com.xl.xlblog.pojo.Result;
import com.xl.xlblog.service.userservice.LeaveMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.spring5.expression.Mvc;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/14
 * @Time 20:10
 */
@Controller
@RequestMapping("/blog")
public class LeaveMessageController {

    @Autowired
    LeaveMessageService leaveMessageService;

    @RequestMapping("/message")
    public ModelAndView message(){
        List<LeaveMessage> leaveMessages = leaveMessageService.pageSelectLeaveMessage();
        ModelAndView mv = new ModelAndView();
        mv.addObject("leaveMessages",leaveMessages);
        mv.setViewName("message");
        return mv;
    }

    @GetMapping("/getLeaveMessage")
    public ModelAndView getLeaveMessage(){
        List<LeaveMessage> leaveMessages = leaveMessageService.pageSelectLeaveMessage();
        ModelAndView mv = new ModelAndView();
        mv.addObject("leaveMessages",leaveMessages);
        mv.setViewName("message :: leaveMessage-list");
        return mv;
    }

    @PostMapping("/insertLeaveMessage")
    @ResponseBody
    public Result insertLeaveMessage(LeaveMessage leaveMessage, HttpSession session){
        return leaveMessageService.insertLeaveMessage(leaveMessage, session);
    }

    @PostMapping("/deleteLeaveMessage/{id}/")
    @ResponseBody
    public Result deleteLeaveMessage(@PathVariable("id") Long id) {
        return leaveMessageService.deleteLeaveMessage(id);
    }
}
