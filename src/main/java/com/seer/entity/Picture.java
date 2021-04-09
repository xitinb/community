package com.seer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description：照片墙实体类
 * @Author :SeerLiang
 * @Date :2021/4/7 21:10
 * @Version :1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Picture {
    private Long id ;  //主键- 照片id
    private String pictureName;  // 照片名
    private String pictureTime; //照片时间
    private String pictureAddress; // 照片地址
    private String pictureDescription; // 照片描述


}

