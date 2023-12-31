package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    /**
     * 注解开发，适用于简单功能，简单sql语句
     *      *查询：@Select
     *      *添加：@Insert
     *      *修改：@Update
     *      *删除：@Delete
     * 配置文件xml，适用于完成复杂功能，复杂sql语句
     */
    @Select("select * from tb_user where id = #{id}")
    User selectById(int id);


    /*
        MyBatis 参数封装：
            *单个参数：
                1.POJO类型：直接使用，属性名 和 参数占位符 名称一致
                2.Map集合：直接使用，键名 和 参数占位符 名称一致
                3.Collection：封装为Map集合，可以使用@Parame注解，替换Map集合中默认的arg0键名。
                    map.put("arg0",collection集合);
                    map.put("collection",collection集合);
                4.List：封装为Map集合
                    map.put("arg0",List集合);
                    map.put("collection",List集合);
                    map.put("List",List集合);
                5.Array：封装为Map集合
                    map.put("arg0",数组);
                    map.put("array",数组);
                6.其他类型
            *多个参数：封装为Map集合
                map.put("arg0",参数值1)
                map.put("param1",参数值1)
                map.put("arg1",参数值2)
                map.put("param2",参数值2)
     */

    User select(@Param("username") String username,@Param("password") String password);
}
