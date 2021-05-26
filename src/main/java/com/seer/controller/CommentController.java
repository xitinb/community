package com.seer.controller;

import com.seer.entity.queryvo.Comment;
import com.seer.service.CommentService;
import com.seer.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description： 评论控制器
 * @Author :SeerLiang
 * @Date :2021/4/19 9:17
 * @Version :1.0
 */

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostingService postingService;

    //查询评论列表
    @GetMapping("/comments/{postingId}")
    public String comments(@PathVariable Long postingId, Model model){
        List<Comment> comments = commentService.listCommentByPostingId(postingId);
        model.addAttribute("comments",comments);
        return "posting :: commentList";
    }

}
