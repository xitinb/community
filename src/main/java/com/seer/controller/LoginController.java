package com.seer.controller;

import com.seer.utils.http.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class UserController {

    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.secret}")
    private String secret;
    @Value("${wx.grantType}")
    private String grantType;
    @Value("${wx.sessionHost}")
    private String sessionHost;

    /**
     * 请求微信服务器获取返回的session_key and openid
     * @param code
     * @return
     */
//    @RequestMapping("/wxlogin/{code}")
//    public String wxlogin(@PathVariable("code") String code){
//
//        // 定义JackJson 对象
//        try {
//            String api_url =sessionHost+"?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type="+grantType ;
//            String loginMsg = HttpClientUtil.get(api_url);
//            return loginMsg;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        }
//    }

    @GetMapping("/wxlogin/{code}")
    public ResponseEntity<String> wxlogin(@PathVariable("code") String code) throws IOException {
        String api_url =sessionHost+"?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type="+grantType ;
        String loginMsg = HttpClientUtil.get(api_url);
        return ResponseEntity.ok(loginMsg);
    }
    /**
     * 查询已授权数据库中的数据
     * 是否由此用户
     * @return
     */
    @RequestMapping("/ishasUser/{openid}")
    public String ishasUser(@PathVariable("openid") String openid){
        log.info("查询该用户是否有记录");
        Wxuserinfo wxuserinfo = wxUserInfoService.findByOpenId(openid);
        if(wxuserinfo!=null){
            return "true";
        }else{
            return "false";
        }
    }

    /**
     * 授权此用户 将此用户保存到数据库中
     * @return
     */
    @RequestMapping("/authorizeUser")
    public String authorizeUser(Wxuserinfo wxuserinfo){
        log.info("授权此用户");
        int addcoount = wxUserInfoService.addWxUserInfo(wxuserinfo);
        return (addcoount==0)?"false":"true";
    }
}
