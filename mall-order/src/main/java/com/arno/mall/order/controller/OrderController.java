package com.arno.mall.order.controller;

import com.arno.mall.order.entity.Order;
import com.arno.mall.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/")
    public String home(){
        return "welcome to mall-order";
    }

    @GetMapping("/order/{id}")
    public Order findOrderById(@PathVariable("id") String id){

        return orderService.findOrderById(id);
    }
}
