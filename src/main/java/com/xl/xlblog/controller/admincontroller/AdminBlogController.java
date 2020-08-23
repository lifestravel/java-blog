package com.xl.xlblog.controller.admincontroller;

import com.xl.xlblog.pojo.Blog;
import com.xl.xlblog.pojo.Result;
import com.xl.xlblog.pojo.Type;
import com.xl.xlblog.pojo.User;
import com.xl.xlblog.service.adminservice.AdminBlogService;
import com.xl.xlblog.service.adminservice.AdminTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/7/31
 * @Time 20:58
 */
@Controller
@RequestMapping("/admin")
public class AdminBlogController {

    @Autowired
    AdminBlogService adminBlogService;

    @Autowired
    AdminTypeService adminTypeService;

    @GetMapping("/blogHtml")
    public ModelAndView blogHtml() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/blogs");
        return mv;
    }

    @GetMapping("/blogAddHtml")
    public ModelAndView blogAddHtml() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/blogs-input");
        return mv;
    }

    @ResponseBody
    @PostMapping("/addBlog")
    public Result addBlog(@Valid Blog blog, long typeId, BindingResult bindingResult,@SessionAttribute("user") User user){
        if (bindingResult.hasErrors()){
            Result result =new Result();
            result.setCode(0);
            result.setMessage("请输入必要完整的信息!");
            return result;
        }
        Result result = adminBlogService.addBlog(blog, typeId,user.getId());
        return result;
    }

    @GetMapping("pageSelectBlog")
    @ResponseBody
    public Result pageSelectBlog(@RequestParam(name = "currentPage",defaultValue = "1") int currentPage,
                                 @RequestParam(name = "pageSize",defaultValue = "4") int pageSize,
                                 String title,String typeName,boolean recommended){
       return adminBlogService.pageSelectBlog(currentPage,pageSize,title,typeName,recommended);
    }

    @RequestMapping("/delBlog/{id}")
    @ResponseBody
    public Result pageSelectBlog(@PathVariable("id") Long id){
        return adminBlogService.delBlog(id);
    }


    @GetMapping("/editBlogHtml")
    public ModelAndView editBlogHtml(@RequestParam("id") Long id){
        ModelAndView mv = new ModelAndView();
        Blog blog = adminBlogService.selectBlogById(id);
        Type type = adminTypeService.selectTypeByBlogId(id);
        mv.addObject("blog",blog);
        mv.addObject("type",type);
        mv.setViewName("admin/blogs-edit");
        return mv;
    }

    @ResponseBody
    @PostMapping("/editBlog")
    public Result editBlog(Blog blog, @Valid @NotNull(message="类型不能为空") @Min(1) long typeId){
        return adminBlogService.editBlog(blog,typeId);
    }
}
