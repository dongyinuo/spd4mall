package com.arno.mall.item.service;

import com.arno.mall.item.entity.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Map<Long, Item> items = new HashMap<Long,Item>();

    static {
        items.put(1L, new Item(1L,"iphone 7", "this is iphone 7", 4000d));
        items.put(2L, new Item(2L,"iphone 8", "this is iphone 8", 5000d));
        items.put(3L, new Item(3L,"iphone 9", "this is iphone 9", 6000d));
        items.put(4L, new Item(4L,"mix3", "this is mix3", 3000d));
        items.put(5L, new Item(5L,"mix4", "this is mix4", 4000d));
        items.put(6L, new Item(6L,"mix5", "this is mix5", 4000d));
    }

    @Override
    public Item findItemById(long id) {
        return items.get(id);
    }
}
