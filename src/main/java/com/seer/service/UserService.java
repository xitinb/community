package com.seer.service;

import com.seer.entity.User;

/**
 * @Description：用户业务层接口
 * @Author :SeerLiang
 * @Date :2021/4/8 18:05
 * @Version :1.0
 */


public interface UserService {
    //核对用户名和密码
    User checkUser(String username);
}
