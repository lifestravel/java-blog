package com.xl.xlblog.controller.usercontroller;

import com.github.pagehelper.PageInfo;
import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.service.userservice.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/28
 * @Time 21:00
 */
@Controller
public class HomeController {
    @Autowired
    IndexService indexService;


    @RequestMapping("")
    public ModelAndView index(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        ModelAndView mv = new ModelAndView();
        PageInfo<Blog> pageInfo = indexService.latestBlog(currentPage, pageSize);
        List<Blog> blogs = indexService.latestRecommended();
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("recommended", blogs);
        mv.setViewName("index");
        return mv;
    }
}
