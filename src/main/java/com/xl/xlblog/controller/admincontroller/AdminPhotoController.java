package com.xl.xlblog.controller.admincontroller;

import com.github.pagehelper.PageInfo;
import com.xl.xlblog.pojo.Photo;
import com.xl.xlblog.pojo.Result;
import com.xl.xlblog.service.adminservice.AdminPhotoService;
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
public class AdminPhotoController {

    @Autowired
    AdminPhotoService adminPhotoService;

    @GetMapping("/pictureHtml")
    public ModelAndView pictureHtml(@RequestParam(value = "currentPage",defaultValue = "1") int currentPage,
                                    @RequestParam(value = "pageSize",defaultValue = "5") int pageSize) {
        ModelAndView mv = new ModelAndView();
        PageInfo<Photo> photoPageInfo = adminPhotoService.pageSelectPhoto(currentPage, pageSize);
        mv.addObject("pageInfo",photoPageInfo);
        mv.setViewName("admin/pictures");
        return mv;
    }

    @GetMapping("/pictureAddHtml")
    public ModelAndView pictureAddHtml() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/pictures-input");
        return mv;
    }

    @PostMapping("/delPhoto/{id}/")
    @ResponseBody
    public Result delPhoto(@PathVariable("id") Long id){
       return adminPhotoService.delPhotoById(id);
    }

    @PostMapping("addPhoto")
    @ResponseBody
    public Result addPhoto(@Valid Photo photo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            Result result = new Result();
            result.setCode(0);
            result.setMessage("请输入必要的添加信息!");
            return result;
        }
        return adminPhotoService.addPhoto(photo);
    }

    @GetMapping("/pageSelectPhoto")
    public ModelAndView pageSelect(@RequestParam(value = "currentPage",defaultValue = "1") int currentPage,
                                    @RequestParam(value = "pageSize",defaultValue = "5") int pageSize) {
        ModelAndView mv = new ModelAndView();
        PageInfo<Photo> photoPageInfo = adminPhotoService.pageSelectPhoto(currentPage, pageSize);
        mv.addObject("pageInfo",photoPageInfo);
        mv.setViewName("admin/pictures :: photo-list");
        return mv;
    }

    @PostMapping("/editPhoto")
    @ResponseBody
    public Result editPhoto(@Valid Photo photo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            Result result = new Result();
            result.setCode(0);
            result.setMessage("请输入必要的修改信息!");
            return result;
        }
        return adminPhotoService.editPhoto(photo);
    }

    @GetMapping("/editPhotoHtml/{id}/")
    public ModelAndView editPhotoHtml(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView();
        Photo photo = adminPhotoService.selectPhotoById(id);
        mv.addObject("photo",photo);
        mv.setViewName("admin/pictures-edit");
        return mv;
    }
}
