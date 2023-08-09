package com.itheima_01.mapper;

import com.itheima_01.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author : [Jiu Meng]
 * @createTime : [2023/7/6 9:08]
 */
public interface UserMapper1 {
    /**
     * 根据用户名和密码查询用户对象
     * @param username 用户名
     * @param password 密码
     * @return User对象
     */
    @Select("select * from db1.tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询用户对象
     * @param username 用户名
     * @return User对象
     */
    @Select("select * from db1.tb_user where username = #{username}")
    User selectByName(@Param("username") String username);

    /**
     * 添加用户数据
     * @param user User对象
     */
    @Select("insert into db1.tb_user values(#{password},#{username},null)")
    void add(User user);
}
