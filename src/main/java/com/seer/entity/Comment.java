package com.seer.entity.queryvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description：查询封装的comment类
 * @Author :SeerLiang
 * @Date :2021/4/19 9:27
 * @Version :1.0
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
        private Long id; //评论id
        private String userId; //用户id
        private String content;  //评论内容
        private Date createTime; //发布时间
        private Long postingId;  //帖子id
        private Long parentCommentId; //评论的父is
        private boolean userComment;  //楼主的标记
        private String avatar;  //头像

        private String username;     //用户名
        private String parentUsername;

    //回复列表
    private List<Comment> replyComments=new ArrayList<>();
    private Comment parentComment; // 父评论

    private DetailedPosting posting;

}
