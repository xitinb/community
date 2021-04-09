package com.seer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description：留言实体类
 * @Author :SeerLiang
 * @Date :2021/4/7 21:16
 * @Version :1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {

    private Long id; //主键 -留言id
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    private Long parentMessageId;
    private boolean adminMessage;

    //回复评论
    private List<Message> replyMessages =new ArrayList<>();
    private Message parentMessage;
    private String parentNickname;


}
