package com.wallet.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wallet.entiy.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Pom
 */
public interface PaymentDao extends BaseMapper<User> {
    @Select("select * from user where id =#{i}")
    User find(int i);
    @Update("update user set shopjifen=shopjifen+#{user.shopjifen},yue=yue+#{user.yue} where username = #{user.username}")
    void update(@Param("user") User user);
    @Insert("insert into user(username,shopjifen,yue) values(#{user.username},#{user.shopjifen},#{user.yue})")
     void add(@Param("user") User user);
   @Select("select * from user where username = #{username}")
    User findbyname(String username);
}
