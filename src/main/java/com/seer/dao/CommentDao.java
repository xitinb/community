package com.seer.dao;

import com.seer.entity.InsertComment;
import com.seer.entity.queryvo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description：评论持久层接口
 * @Author :SeerLiang
 * @Date :2021/4/19 9:18
 * @Version :1.0
 */

@Mapper
@Repository
public interface CommentDao {
    //测试
    //List<Comment> testquery();

    //通过帖子id查询出父id为空的评论列表
    List<Comment> findByPostingIdParentIdNUll(@Param("postingId") Long postingId,@Param("postingParentId") Long postingParentId);

    //通过帖子id查询出父id不为空的回复列表（一级回复）
    List<Comment> findByPostingIdParentIdNotNull(@Param("postingId") Long postingId,@Param("id")Long id);

    //(二级回复)
    List<Comment> findByPostingIdAndReplayId(@Param("postingId")Long postingId,@Param("childId") Long childId);

    //添加一个评论
    int saveComment(InsertComment insertComment);

    //删除评论
    void deleteComment(Long CommmentId);
    //通过评论id查询评论者名字
//     String findUsernameByCommentId(Long CommentId);
}
