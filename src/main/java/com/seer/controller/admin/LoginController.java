package com.seer.controller.admin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Description：用户登录控制器
 * @Author :SeerLiang
 * @Date :2021/4/8 17:16
 * @Version :1.0
 */

@Controller
@RequestMapping("/admin")
public class LoginController  {

    //跳转登录页面
    @GetMapping
    public String loginPage(){
    return "admin/login";
    }

    //登录校验-shiro
    @PostMapping("/login")
    public String login(String username, String password, Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            System.out.println("登录成功！");
            return "/admin/testindex";
        }catch (UnknownAccountException e){  //找不到用户
            model.addAttribute("message","用户名错误");
            return "/admin/login";
        }catch (IncorrectCredentialsException e){  //密码错误
            model.addAttribute("message","密码错误");
            return "/admin/login";
        }
    }


    //注销
    @GetMapping("/logout")
    public String logout(){

        return "redirect:/admin";
    }
}
