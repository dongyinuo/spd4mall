package com.arno.mall.order;

import com.arno.mall.order.service.OrderService;
import com.arno.mall.order.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderContext {

    @Bean
    public OrderService orderService(RestTemplate restTemplate){
        return new OrderServiceImpl(restTemplate);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
