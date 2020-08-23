package com.xl.xlblog.controller.usercontroller;

import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.service.userservice.TimestampService;
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
public class TimestampController {

    @Autowired
    TimestampService timestampService;

    @RequestMapping("/archives")
    public ModelAndView archives(){
        ModelAndView mv = new ModelAndView();
        List<Blog> timestamp = timestampService.getTimestamp();
        mv.addObject("timestamp",timestamp);
        mv.setViewName("archives");
        return mv;
    }
}
