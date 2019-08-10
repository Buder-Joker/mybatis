package com.bittch.mapper;

import com.bittch.po.Orders;
import com.bittch.po.OrdersEx;

import java.util.List;

public interface OrderMapper {
    public List<OrdersEx> QuerOrderToUser() throws Exception;

    public List<Orders> queryOrderToItems() throws Exception;

}
