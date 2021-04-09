package com.seer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description：评论实体类
 * @Author :SeerLiang
 * @Date :2021/4/7 20:41
 * @Version :1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    private Long id ;  //评论的主键
    private String nickname; // 昵称
    private String email; //邮件
    private String content; // 评论内容

    private String avatar; // 头像
    private Date createTime; // 创建时间

    private Long blogId;  // 外键-博客id
    private Long parentCommentId; //父评论 id
    private String parentNickname;  // 父评论昵称

    //回复评论
    private List<Comment> replyComments = new ArrayList<>(); // 回复列表
    private Comment parentComment; //
    private boolean adminComment; //

    //private DetailedBlog blog;
}
