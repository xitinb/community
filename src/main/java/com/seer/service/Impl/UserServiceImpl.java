package com.seer.service.Impl;

import com.seer.dao.UserDao;
import com.seer.entity.User;
import com.seer.service.UserService;
import com.seer.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description：用户业务层接口实现类
 * @Author :SeerLiang
 * @Date :2021/4/8 18:05
 * @Version :1.0
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User checkUser(String username) {
        User user = userDao.findByUsername(username);
        return user;
    }
}
