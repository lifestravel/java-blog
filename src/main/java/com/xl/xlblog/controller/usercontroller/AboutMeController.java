package com.xl.xlblog.controller.usercontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/14
 * @Time 20:10
 */
@Controller
@RequestMapping("/blog")
public class AboutMeController {

    @RequestMapping("/aboutMe")
    public String about(){
        return "about";
    }
}
