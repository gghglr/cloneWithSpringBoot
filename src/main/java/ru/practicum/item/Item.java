package ru.practicum.item;

import lombok.*;
import ru.practicum.user.User;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "items")
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User user;


    @Column
    private String url;
    // здесь остальные поля

    @ElementCollection
    @CollectionTable(name="tags", joinColumns=@JoinColumn(name="item_id"))
    @Column(name="name")
    private Set<String> tags = new HashSet<>();
}