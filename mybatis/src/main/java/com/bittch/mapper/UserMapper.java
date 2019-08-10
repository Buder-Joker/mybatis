package com.bittch.mapper;

import com.bittch.bz.UserBz;
import com.bittch.po.User;
import com.bittch.po.UserEx;

import java.util.List;

public interface UserMapper {

    public List<UserEx> querUserByZH(UserBz userBz) throws Exception;

    public int queryUserByCount(UserBz userBz) throws Exception;

    public List<UserEx> queryUserByAlias() throws Exception;

    public List<User> queryUserByAlias2() throws Exception;


}
