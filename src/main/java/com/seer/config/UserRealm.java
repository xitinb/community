package com.seer.config;

import com.seer.entity.User;
import com.seer.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description：shiro授权认证
 * @Author :SeerLiang
 * @Date :2021/4/8 17:45
 * @Version :1.0
 */
public class UserRealm extends AuthorizingRealm {

   @Autowired
    private UserService userService;


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("shiro执行了=》授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();  //拿到user对象

        //设置当前用户的权限
        info.addStringPermission(currentUser.getPerm());


        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("shiro执行了=》认证");

        //注意：subject.login(token);
        UsernamePasswordToken userToken =(UsernamePasswordToken) token;


        //与数据库查询到用户认证
        User user = userService.checkUser(userToken.getUsername());

        if (user!=null) { //测试代码
            System.out.println("userToken的信息 ：" + userToken.getUsername() + userToken.getCredentials());
            System.out.println("shiro查询的用户" + user.getUsername());
        }
        if (user==null){  //没有此用户，就会报unknowAccountException
            return null;
        }

        //密码验证，shiro做
        return new SimpleAuthenticationInfo(user, user.getPassword(),"");
    }
}
