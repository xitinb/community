package com.seer.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description：shiro配置类
 * @Author :SeerLiang
 * @Date :2021/4/8 17:45
 * @Version :1.0
 */

@Configuration
public class ShiroConfig {
    //shiroFilterFactoryBean3
     @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("security")DefaultWebSecurityManager defaultWebSecurityManager){
    ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
    //设置安全管理器
    bean.setSecurityManager(defaultWebSecurityManager);
   //添加shiro的内置过滤器
    /*
     * anno:无需认证就可以访问
     * authc:必须认证才可以访问
     * user:必须拥有记住我功能才能访问
     * perms；拥有某个资源的权限才能访问
     * role：拥有某个角色权限才能访问
     * */
    Map<String, String> filterMap = new LinkedHashMap<>();

    //拦截
    //授权，正常的情况下，没有授权会跳转到没有授权页面
    //    filterMap.put("/admin/add","perms[user:add]");
    //    filterMap.put("/admin/update","perms[user:update]");

    filterMap.put("/admin/testindex","perms[user:testindex]");
    filterMap.put("/admin/*","authc");

    bean.setFilterChainDefinitionMap(filterMap);

    //设置登录的请求
    bean.setLoginUrl("/admin/login");
    //设置没授权的跳转
//    bean.setUnauthorizedUrl("");

    return bean;
}

    //DefaultWebSecurityManager 2
    @Bean(name = "security")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    //创建realm对象，需要自定义类 1
    @Bean
    public UserRealm userRealm(){
    return new UserRealm();
    }

    //整合shiroDialect:用来整合shiro和thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
       return new ShiroDialect();
    }
}
