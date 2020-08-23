package com.xl.xlblog.controller.usercontroller;

import com.xl.xlblog.pojo.Photo;
import com.xl.xlblog.service.userservice.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
public class PhotoController {

    @Autowired
    PhotoService photoService;
    @RequestMapping("/picture")
    public ModelAndView picture(){
        ModelAndView mv = new ModelAndView();
        List<Photo> photos = photoService.selectAllPhoto();
        mv.addObject("photos",photos);
        mv.setViewName("picture");
        return mv;
    }

}
