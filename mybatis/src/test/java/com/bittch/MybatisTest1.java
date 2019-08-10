package com.bittch;


import com.bittch.bz.UserBz;
import com.bittch.mapper.OrderMapper;
import com.bittch.mapper.UserMapper;
import com.bittch.po.Orders;
import com.bittch.po.OrdersEx;
import com.bittch.po.User;
import com.bittch.po.UserEx;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class MybatisTest1 {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void testInitialtive(){
        String file = "sqlMapConfig.xml";
        InputStream is = null;
        try{
            is = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //根据订单表查询用户User
    @Test
    public void testQuerOrderToUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{

            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            List<OrdersEx> userExList = orderMapper.QuerOrderToUser();
            System.out.println(userExList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    //根据订单表查询商品表
    @Test
    public void testQueryOrderToItems(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{

            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            List<Orders> ItemList = orderMapper.queryOrderToItems();
            System.out.println(ItemList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
