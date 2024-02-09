package ru.practicum.itemNote;

import lombok.*;
import ru.practicum.item.Item;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "item_notes")
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Item item;

    private String text;

    @Column(name = "note_date")
    private Instant dateOfNote = Instant.now();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemNote)) return false;
        return id != null && id.equals(((ItemNote) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}