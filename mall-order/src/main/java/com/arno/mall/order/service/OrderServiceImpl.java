package com.arno.mall.order.service;

import com.arno.mall.order.entity.Item;
import com.arno.mall.order.entity.Order;
import com.arno.mall.order.entity.OrderDetail;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final RestTemplate restTemplate;

    private final static Map<String,Order> orders = new HashMap<String, Order>();

    static {
        Order order = new Order();
        order.setOrderId("11111");
        order.setUserId(1l);
        order.setCreateDate(new Date());
        order.setUpdateDate(order.getCreateDate());

        //-- 构造 orderDetails
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setOrderId(order.getOrderId());
        Item item1 = new Item();
        item1.setId(1L);
        orderDetail1.setItem(item1);
        orderDetails.add(orderDetail1);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setOrderId(order.getOrderId());
        Item item2 = new Item();
        item2.setId(2L);
        orderDetail2.setItem(item2);
        orderDetails.add(orderDetail2);
        //--

        order.setOrderDetails(orderDetails);
        orders.put(order.getOrderId(), order);
    }

    @Override
    public Order findOrderById(String id) {

        Order order = orders.get(id);

        // compose orderDetails
        order.getOrderDetails().forEach(orderDetail -> {
            Long itemId = orderDetail.getItem().getId();
            Item item = restTemplate.getForObject("http://localhost:8083/item/" + itemId, Item.class);
            orderDetail.setItem(item);
        });
        return order;
    }
}
