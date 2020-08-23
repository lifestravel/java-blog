package com.xl.xlblog.controller.usercontroller;

import com.xl.xlblog.pojo.FriendLink;
import com.xl.xlblog.service.userservice.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/14
 * @Time 20:09
 */
@Controller
@RequestMapping("/blog")
public class FriendLinkController {

    @Autowired
    FriendLinkService friendLinkService;

    @RequestMapping("/friends")
    public ModelAndView friends(){
        ModelAndView mv = new ModelAndView();
        List<FriendLink> friendLinks = friendLinkService.selectAllFriendLink();
        mv.setViewName("friends");
        mv.addObject("friendLinks",friendLinks);
        return mv;
    }

}
