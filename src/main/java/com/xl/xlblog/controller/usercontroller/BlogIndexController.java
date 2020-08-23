package com.xl.xlblog.controller.usercontroller;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xl.xlblog.exceptionHandler.NotFoundException;
import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.service.userservice.BlogDetailsService;
import com.xl.xlblog.service.userservice.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/7/30
 * @Time 9:35
 */
@Controller
@RequestMapping("/blog")
public class BlogIndexController {

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

    @PostMapping("/pageSelectBlog")
    public ModelAndView pageSelectBlog(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        ModelAndView mv = new ModelAndView();
        System.out.println(currentPage);
        PageInfo<Blog> pageInfo = indexService.latestBlog(currentPage, pageSize);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("index :: blog-content");
        System.out.println();
        return mv;
    }

}
