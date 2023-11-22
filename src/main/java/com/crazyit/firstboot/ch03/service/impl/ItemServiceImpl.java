package com.crazyit.firstboot.ch03.service.impl;

import com.crazyit.firstboot.ch03.domain.Item;
import com.crazyit.firstboot.ch03.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ItemServiceImpl implements ItemService {
    private final Map<Integer, Item> data = new ConcurrentHashMap<>();
    private static final AtomicInteger idGenerator = new AtomicInteger(0);

    @Override
    public Item getItemById(Integer id) {
        return this.data.get(id);
    }

    @Override
    public Item createOrUpdate(Item item) {
        // 修改物品
        if (item.getId() != null && data.containsKey(item.getId())) {
            this.data.put(item.getId(), item);
        } else {
            Integer id = idGenerator.incrementAndGet();
            item.setId(id);
            this.data.put(id, item);
        }
        return item;
    }

    @Override
    public Item delete(Integer id) {
        return this.data.remove(id);
    }

    @Override
    public Collection<Item> list() {
        return this.data.values();
    }
}
