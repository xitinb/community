package com.seer.entity;

import com.seer.entity.queryvo.DetailedPosting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description：新增专用的实体类
 * @Author :SeerLiang
 * @Date :2021/4/19 9:27
 * @Version :1.0
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InsertComment {
        private Long id; //评论id
        private String userId; //用户id
        private String content;  //评论内容
        private Date createTime; //发布时间
        private Long postingId;  //帖子id
        private Long parentCommentId; //评论的父is
        private boolean userComment;  //楼主的标记
}
