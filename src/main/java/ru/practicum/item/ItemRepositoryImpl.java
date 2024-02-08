package ru.practicum.item;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl {

    public List<Item> findByUserId(long userId) {
        return null;
    }

    public Item save(Item item) {
        return null;
    }

    public void deleteByUserIdAndItemId(long userId, long itemId) {

    }
}
