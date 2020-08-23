package com.xl.xlblog.controller.usercontroller;

import com.github.pagehelper.PageInfo;
import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.pojo.Type;
import com.xl.xlblog.service.userservice.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/14
 * @Time 14:15
 */
@Controller
@RequestMapping("/blog")
public class TypeController {

    @Autowired
    TypeService typeService;

    @RequestMapping("/blogTypes")
    public ModelAndView types(@RequestParam(value = "currentPage",defaultValue = "1") int currentPage,
                              @RequestParam(value = "pageSize",defaultValue = "5") int pageSize){
        ModelAndView mv = new ModelAndView();
        PageInfo<Blog> pageInfo = new PageInfo<>();
        List<Type> types = typeService.selectAllType();
        if (types != null && types.size()>0){
            Long typeId = types.get(0).getId();
            pageInfo = typeService.pageSelectBlogByType(currentPage, pageSize, typeId);
        }
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("types");
        mv.addObject("typeList",types);
        return mv;
    }


    @GetMapping("/pageSelectBlogByTypeId")
    public ModelAndView pageSelectBlogByTypeId(@RequestParam(value = "currentPage",defaultValue = "1") int currentPage,
                                               @RequestParam(value = "pageSize",defaultValue = "5") int pageSize,
                                               @RequestParam("typeId") Long typeId){
        ModelAndView mv = new ModelAndView();
        PageInfo<Blog> pageInfo = typeService.pageSelectBlogByType(currentPage, pageSize, typeId);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("types :: blogList");
        return mv;
    }
}
