package com.seer.controller;

import com.seer.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description 首页控制器
 * @Author SeerLiang
 * @Date 2021/3/31 16:43
 * @Version 1.0
 */

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        //int a=9/0;
//        String blog=null;
//        if (blog==null){
//            throw new NotFoundException("博客不存在");
//        }
        return "index";
    }
}
