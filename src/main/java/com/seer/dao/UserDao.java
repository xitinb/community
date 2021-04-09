package com.seer.dao;

import com.seer.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @Description：用户持久层接口
 * @Author :SeerLiang
 * @Date :2021/4/8 17:56
 * @Version :1.0
 */

@Mapper
@Repository
public interface UserDao {
    User findByUsername(@Param("username") String username);
}
