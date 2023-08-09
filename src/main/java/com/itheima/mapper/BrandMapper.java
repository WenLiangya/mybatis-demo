package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Jiu Meng
 */
public interface BrandMapper {

    /**
     * 查询所有
     */
    List<Brand> selectAll();

    /**
     * 条件查询
     * @param id id
     * @return int类型id
     */
    Brand selectById(int id);

    /*
      条件查询
       *参数接收方法
           1.散装参数，若方法中有多个参数，需使用@Param("SQL参数占位符名称)
           2.对象参数
           3.map集合参数
     */

//    /**
//     * 1.散装参数
//     * @param status 当前状态
//     * @param companyName 公司名称
//     * @param brandName 品牌名称
//     */
//    List<Brand> selectByCondition(@Param("status") int status,
//                                  @Param("companyName") String companyName,
//                                  @Param("brandName") String brandName);

//    /**
//     * 2.封装对象
//     * @param brand 封装参数对象
//     */
//    List<Brand> selectByCondition(Brand brand);

    /**
     * 3.map集合参数
     * @param map map集合参数
     * @return map
     */
    List<Brand> selectByCondition(Map map);

    /**
     * 单条件动态查询
     * @param brand 封装对象参数
     * @return brand
     */
    List<Brand> selectByConditionSingle(Brand brand);

    /**
     * 添加
     */
    void add(Brand brand);

    /**
     * 修改全部字段
     */
    int update(Brand brand);

    /**
     * 修改动态字段
     */
    int updateDynamic(Brand brand);

    /**
     * 根据id删除单条
     */
    void deleteById(int id);

    /**
     * 根据id删除多条数据
     */
    void deleteByIds(@Param("ids") int[] ids);
}
