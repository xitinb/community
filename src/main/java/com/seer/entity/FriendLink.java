package com.seer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Description：友情链接实体类
 * @Author :SeerLiang
 * @Date :2021/4/7 21:23
 * @Version :1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FriendLink {

    private  Long id;  //主键 -友情链接id
    private String blogName;
    private String blogAddress;
    private String pictureAddress;
    private Date createTime;

}
