package com.seer.service;

import com.seer.entity.InsertComment;
import com.seer.entity.queryvo.Comment;

import java.util.List;

/**
 * @Description：评论业务层接口
 * @Author :SeerLiang
 * @Date :2021/4/19 9:18
 * @Version :1.0
 */
public interface CommentService {
    //通过帖子Id查询评论列表
    List<Comment> listCommentByPostingId(Long postingId);

    //新增保存评论
    int saveComment (InsertComment insertComment);

    //删除评论
    void deleteComment(Comment comment,Long id);
}
