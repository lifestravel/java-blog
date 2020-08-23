package com.xl.xlblog.controller.admincontroller;
import com.xl.xlblog.pojo.Result;
import com.xl.xlblog.pojo.User;
import com.xl.xlblog.service.adminservice.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;


/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/7/30
 * @Time 21:42
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminUserService adminUserService;

    @Autowired
    Result result;

    /**
     * 登录
     * @param username
     * @param password
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/userLogin")
    public Result userLogin(@RequestParam("username") String username, @RequestParam("password") String password,
                            HttpServletRequest request) throws UnsupportedEncodingException {
        User user = adminUserService.userLogin(username, password);
        if (user == null){
            result.setCode(0);
            result.setMessage("登陆失败!账户名或者密码错误!");
        }else {
            user.setPassword("");
            request.getSession().setAttribute("user",user);
            result.setCode(1);
        }
        return result;
    }

    /**
     * 登录界面
     * @return
     */
    @RequestMapping("/loginHtml")
    public String loginHtml(){
        return "admin/login";
    }

    /**
     * 登录成功跳转页面
     * @return
     */
    @RequestMapping("/indexHtml")
    public ModelAndView indexHtml(HttpServletRequest request){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("admin/index");
        return mv;
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null){
            session.removeAttribute("user");
        }
        return "redirect:/admin/loginHtml";
    }


}
