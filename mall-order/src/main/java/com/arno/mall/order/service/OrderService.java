package com.arno.mall.order.service;

import com.arno.mall.order.entity.Order;

public interface OrderService {

    /**
     * 根据订单 id 查询订单信息
     * @param id
     * @return
     */
    Order findOrderById(String id);
}
