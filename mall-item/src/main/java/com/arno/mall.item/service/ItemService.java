package com.arno.mall.item.service;

import com.arno.mall.item.entity.Item;

public interface ItemService {

    /**
     * 根据商品 id 查询商品
     * @param id
     * @return
     */
    Item findItemById(long id);
}
