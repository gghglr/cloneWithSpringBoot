package ru.practicum.itemNote;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.practicum.item.Item;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public interface ItemNoteRepository extends JpaRepository<ItemNote, Long> {

    //List<ItemNote> findAllByItemUserIdAndItemUrlContaining(long userId, String url);
    //@Query("select itNote from ItemNote as itNote join itNote.item as i where i.user.id = ?1 and ?2 member of i.tags")
    //List<ItemNote> findByTag(Long userId, String tag);

    /* селектим таблицу в фром указываем название класса затем это джоиним с итемом и теперь у нас есть доступ и к юзеру и потом уже условия */
    List<ItemNote> findAllByItemUrlContainingAndItemUserId(String itemUrl, Long userId);

    @Query("select itNote " +
            "from ItemNote as itNote " +
            "join itNote.item as i " +
            "where i.user.id = ?1" +
            "  and ?2 member of i.tags")
    List<ItemNote> findByTag(Long userId, String tag);

    Page<ItemNote> findAllByItemUserId(long userId, Pageable page);
}
