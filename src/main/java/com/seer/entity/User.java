package com.seer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Description：用户实体类
 * @Author :SeerLiang
 * @Date :2021/4/7 20:41
 * @Version :1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private Long id ;  //主键 -用户id
    private String nickname; // 昵称
    private String username; //用户名
    private String password ; //密码
    private String email; // 邮件
    private String avatar; // 头像
    private Integer type; // 用户类型
    private Date createTime; // 创建时间
    private Date updateTime; // 更新时间
    private String perm;  //权限
}
