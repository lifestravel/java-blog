package com.xl.xlblog.controller.usercontroller;

import com.github.pagehelper.PageInfo;
import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.service.userservice.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/9
 * @Time 16:58
 */
@Controller
@RequestMapping("blog")
public class SearchController {

    @Autowired
    SearchService searchService;


    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "currentPage",defaultValue = "1")  int currentPage,
                               @RequestParam(value = "pageSize",defaultValue = "5") int pageSize,
                               @RequestParam("search") String search){
        ModelAndView mv = new ModelAndView();
        PageInfo<Blog> pageInfo = searchService.pageSearch(currentPage, pageSize, search);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("search");
        mv.addObject("searchContent",search);
        return mv;
    }

    @PostMapping("/pageSearch")
    public ModelAndView pageSearch(@RequestParam(value = "currentPage",defaultValue = "1")  int currentPage,
                                   @RequestParam(value = "pageSize",defaultValue = "5") int pageSize,
                                   @RequestParam("search") String search){
        ModelAndView mv = new ModelAndView();
        PageInfo<Blog> pageInfo = searchService.pageSearch(currentPage, pageSize, search);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("search :: search-result");
        mv.addObject("searchContent",search);
        return mv;
    }
}
