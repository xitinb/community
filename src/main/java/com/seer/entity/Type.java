package com.seer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description：分类实体类
 * @Author :SeerLiang
 * @Date :2021/4/7 20:40
 * @Version :1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Type {

    private Long id; //主键 -分类的id
    private String name; //类型名

    private List<Blog> blogs= new ArrayList<>(); //对应的博客列表
}


