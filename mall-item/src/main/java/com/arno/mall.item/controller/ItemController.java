package com.arno.mall.item.controller;

import com.arno.mall.item.entity.Item;
import com.arno.mall.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String home(){
        return "welcome to mall-item";
    }

    @GetMapping("/item/{id}")
    public Item findItemById(@PathVariable("id") Long id){
        return itemService.findItemById(id);
    }
}
