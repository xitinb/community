package com.seer.service.Impl;

import com.seer.dao.CommentDao;
import com.seer.dao.PostingDao;
import com.seer.entity.InsertComment;
import com.seer.entity.queryvo.Comment;
import com.seer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description：评论业务层接口实现类
 * @Author :SeerLiang
 * @Date :2021/4/19 9:19
 * @Version :1.0
 */

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private PostingDao postingDao;

    private List<Comment>tempReplys=new ArrayList<>();

    @Override
    public List<Comment> listCommentByPostingId(Long postingId) {
        //先查询出父节点,parentId-1表示父id为空
        List<Comment> comments = commentDao.findByPostingIdParentIdNUll(postingId, Long.parseLong("-1"));
        //遍历父节点
        for (Comment comment : comments) {
            Long id = comment.getId();
            String parentUsername1 = comment.getUsername();  //父评论的用户名
            List<Comment> childComments = commentDao.findByPostingIdParentIdNotNull(postingId, id);  //查询对应的子集评论
            //查出子评论
            combineChildren(postingId,childComments,parentUsername1);
            comment.setReplyComments(tempReplys);
            tempReplys =new ArrayList<>();
        }

        return comments;
    }

    private void combineChildren(Long postingId,List<Comment> childComments,String parentUsername1){
        //判断是否有一级的子评论
        if(childComments.size()>0){
            for (Comment childComment : childComments) { //
                String parentUsername = childComment.getUsername();
                childComment.setParentUsername(parentUsername1);   //给一级的子评论设置父评论的用户名
                tempReplys.add(childComment);

                //查询出二级的子评论
                Long childId = childComment.getId();
                recursively(postingId,childId,parentUsername);
            }
        }
    }

    private void recursively(Long postingId,Long childId, String parentUsername1){
        //根据一级评论的id找到了二级评论
        List<Comment> replayComments = commentDao.findByPostingIdAndReplayId(postingId, childId);
        if(replayComments.size()>0){
            for (Comment replayComment : replayComments) {
                String parentUsername = replayComment.getUsername();
                replayComment.setParentUsername(parentUsername1);

                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                recursively(postingId,replayId,parentUsername);

            }
        }
    }

    //新增评论
    @Override
    public int saveComment(InsertComment insertComment) {
        insertComment.setCreateTime(new Date());
        int comments = commentDao.saveComment(insertComment);

        //文章评论计数
       // postingDao.getCommentCountById(comment.getPostingId());
        return comments;
    }

    //删除评论
    @Override
    public void deleteComment(Comment comment, Long id) {
        commentDao.deleteComment(id);
//        postingDao.getCommentCountById(comment.getPostingId());
    }
}
