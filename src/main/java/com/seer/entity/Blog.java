package com.seer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description：博客实体类
 * @Author :SeerLiang
 * @Date :2021/4/7 20:32
 * @Version :1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Blog {
    private Long id; //博客的id主键
    private String title; // 博客的标题
    private String content;  // 博客内容
    private String firstPicture; // 首图
    private String flag; // 标记
    private String views; //浏览次数

    private Integer commentCount;  //评论数目

    private boolean appreciation;  // 开启赞赏
    private boolean shareStatement; //版权开启
    private boolean commentabled;  //评论开启
    private boolean published; //是否发布
    private boolean recommend; //是否推荐
    private Date createTime;  //创建时间
    private Date updateTime; //更新时间


    private Long typeId; //外键-类型id
    private Long userId;  //外键-用户id
    private String description;  //描述
    private Type type;  //
    private User user;  //
    private List<Comment> comments=new ArrayList<>();  //评论列表

}
