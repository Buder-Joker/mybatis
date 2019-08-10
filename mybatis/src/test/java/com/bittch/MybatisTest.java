package com.bittch;


import com.bittch.bz.UserBz;
import com.bittch.mapper.UserMapper;
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


public class MybatisTest {

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

    @Test
    public void testQueryUserByZH(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            UserEx userEx = new UserEx();
            userEx.setSex("2");
            userEx.setUsername("vin");
            UserBz userBz = new UserBz();
            userBz.setUserEx(userEx);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<UserEx>  userExList = userMapper.querUserByZH(null);
            System.out.println(userExList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryUserByCount(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            UserEx userEx = new UserEx();
            userEx.setSex("2");
            userEx.setUsername("vin");
            UserBz userBz = new UserBz();
            userBz.setUserEx(userEx);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int result = userMapper.queryUserByCount(null);
            System.out.println("result = " + result);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryUserByAlias(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<UserEx> userExList = userMapper.queryUserByAlias();
            System.out.println(userExList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryUserByAlias2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userExList = userMapper.queryUserByAlias2();
            System.out.println(userExList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
