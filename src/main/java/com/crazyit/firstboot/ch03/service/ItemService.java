package com.crazyit.firstboot.ch03.service;

import com.crazyit.firstboot.ch03.domain.Item;

import java.util.Collection;

public interface ItemService {
    Item getItemById(Integer id);

    Item createOrUpdate(Item item);

    Item delete(Integer id);

    Collection<Item> list();
}
