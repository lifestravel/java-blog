package com.xl.xlblog.controller.admincontroller;


import com.xl.xlblog.pojo.Result;
import com.xl.xlblog.pojo.Type;
import com.xl.xlblog.service.adminservice.AdminTypeService;
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
 * @Time 16:31
 */
@Controller
@RequestMapping("/admin")
public class AdminTypeController {

    @Autowired
    AdminTypeService adminTypeService;

    @GetMapping("/typeHtml")
    public ModelAndView typeHtml() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/types");
        return mv;
    }

    @GetMapping("/typeAddHtml")
    public ModelAndView typeAddHtml() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/types-input");
        return mv;
    }

    @ResponseBody
    @PostMapping("/addType")
    public Result addType(@RequestParam("name") String name) {
        Result result = new Result();
        int i = adminTypeService.addType(name);
        result.setCode(i);
        if (i == 0) {
            result.setMessage("不许添加重复的分类!");
        } else if (i == 1) {
            result.setMessage("插入成功!");
        } else if (i == -1) {
            result.setMessage("类型不能为空!");
        }
        return result;
    }

    @ResponseBody
    @PostMapping("/editType")
    public Result editType( @Valid Type type, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.setCode(0);
            result.setMessage(bindingResult.getAllErrors().get(0).toString());
            return result;
        }
        int i = adminTypeService.editType(type);
        result.setCode(i);
        if (i == 1) {
            result.setMessage("修改成功!");
        } else {
            result.setMessage("修改失败!");
        }
        return result;
    }

    @ResponseBody
    @PostMapping("/delType")
    public Result delType(@RequestParam("id") int id) {
        Result result = new Result();
        int i = adminTypeService.delType(id);
        result.setCode(i);
        if (i == 0) {
            result.setMessage("删除失败!");
        } else {
            result.setMessage("删除成功!");
        }
        return result;
    }

    @ResponseBody
    @GetMapping("/pageSelect")
    public Result pageSelect(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                             @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        return adminTypeService.pageSelect(currentPage, pageSize);
    }

    @ResponseBody
    @GetMapping("/selectAllType")
    public Result selectAll(){
        return adminTypeService.selectAll();
    }
}
