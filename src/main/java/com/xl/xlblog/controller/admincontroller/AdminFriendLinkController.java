package com.xl.xlblog.controller.admincontroller;

import com.github.pagehelper.PageInfo;
import com.xl.xlblog.pojo.FriendLink;
import com.xl.xlblog.pojo.Result;
import com.xl.xlblog.service.adminservice.AdminFriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/7/31
 * @Time 20:55
 */
@Controller
@RequestMapping("/admin")
public class AdminFriendLinkController {

    @Autowired
    AdminFriendLinkService adminFriendLinkService;

    @GetMapping("/friendLinkHtml")
    public ModelAndView friendHtml(@RequestParam(value = "currentPage",defaultValue = "1") int currentPage,
                                   @RequestParam(value = "pageSize",defaultValue = "5") int pageSize) {
        ModelAndView mv = new ModelAndView();
        PageInfo<FriendLink> pageInfo = adminFriendLinkService.pageSelectFriendLink(currentPage, pageSize);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("admin/friendlinks");
        return mv;
    }

    @GetMapping("/friendLinkAddHtml")
    public ModelAndView friendAddHtml() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/friendlinks-input");
        return mv;
    }

    @PostMapping("/delFriendLink/{id}/")
    @ResponseBody
    public Result delFriendLink(@PathVariable("id") Long id){
        return adminFriendLinkService.delFriendLinkById(id);
    }

    @PostMapping("/addFriendLink")
    @ResponseBody
    public Result addFriendLink(@Valid FriendLink friendLink, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            Result result = new Result();
            result.setCode(0);
            result.setMessage("请输入必要的添加信息!");
            return result;
        }
        return  adminFriendLinkService.addFriendLink(friendLink);
    }

    @GetMapping("/pageSelectFriendLink")
    public ModelAndView pageSelect(@RequestParam(value = "currentPage",defaultValue = "1") int currentPage,
                                   @RequestParam(value = "pageSize",defaultValue = "5") int pageSize){
        ModelAndView mv = new ModelAndView();
        PageInfo<FriendLink> pageInfo = adminFriendLinkService.pageSelectFriendLink(currentPage,pageSize);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("/admin/friendlinks :: friendLink-list");
        return mv;
    }
    @PostMapping("/editFriendLink")
    @ResponseBody
    public Result editFriendLink(@Valid FriendLink friendLink,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            Result result = new Result();
            result.setCode(0);
            result.setMessage("请输入必要的修改信息!");
            return result;
        }
        return adminFriendLinkService.editFriendLink(friendLink);
    }

    @GetMapping("/editFriendLinkHtml/{id}/")
    public ModelAndView editFrindLinkHtml(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView();
        FriendLink friendLink = adminFriendLinkService.selectFriendLinkById(id);
        mv.addObject("friendLink" ,friendLink);
        mv.setViewName("admin/friendlinks-edit");
        return mv;
    }
}
