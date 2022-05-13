package com.atguigu.springcloud.alibaba.dao;
import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/*
 * @Author 裴舒凯
 * @Date 2022-05-01 17:20
 */
@Mapper
public class OrderDao {
    //新建订单
    public void create(Order order) {

    }

    //修改订单状态，从零改为1
    public void update(@Param("userId") Long userId, @Param("status") Integer status) {

    }
}
