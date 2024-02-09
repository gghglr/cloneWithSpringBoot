package ru.practicum.item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.user.User;
import ru.practicum.user.UserRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

import javax.annotation.processing.Generated;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
class ItemServiceImpl implements ItemService {
    private ItemRepository repository;
    private UserRepository userRepository;

    @Override
    public List<ItemDto> getItems(long userId) {
        List<Item> userItems = repository.findByUserId(userId);
        return ItemMapper.mapToItemDto(userItems);
    }

    @Transactional
    @Override
    public ItemDto addNewItem(long userId, ItemDto itemDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Item item = repository.save(ItemMapper.mapToItem(itemDto, user));
        return ItemMapper.mapToItemDto(item);
    }

    @Transactional
    @Override
    public void deleteItem(long userId, long itemId) {
        repository.deleteByUserIdAndId(userId, itemId);
    }

    /*@Override
    @Transactional(readOnly = true)
    public List<ItemDto> getItems(long userId, Set<String> tags) {
        BooleanExpression byUserId = QItem.item.user.id.eq(userId);
        BooleanExpression byAnyTag = QItem.item.tags.any().in(tags);
        Iterable<Item> foundItems = repository.findAll(byUserId.and(byAnyTag));
        return ItemMapper.mapToItemDto(foundItems);
    }*/

    @Override
    @Transactional(readOnly = true)
    public List<ItemDto> getUserItems(String lastName) {
        List<Item> foundItems = repository.findItemsByLastNamePrefix(lastName);
        return ItemMapper.mapToItemDto(foundItems);
    }
}