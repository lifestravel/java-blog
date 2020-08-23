package com.xl.xlblog.controller.usercontroller;

import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.service.userservice.BlogDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/10
 * @Time 19:06
 */
@Controller
@RequestMapping("/blog")
public class BlogDetailsController {
    @Autowired
    BlogDetailsService blogDetailsService;

    @RequestMapping("/details/{id}/")
    public ModelAndView blogDetails(@PathVariable("id") Long id){
        System.out.println(id);
        ModelAndView mv = new ModelAndView();
        Blog blog = blogDetailsService.selectBlogDetails(id);
        mv.addObject("blog",blog);
        mv.setViewName("blog");
        return mv;
    }

}
