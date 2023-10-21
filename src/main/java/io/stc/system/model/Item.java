package io.stc.system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.stc.system.model.enums.ItemType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;

import java.util.List;

@Getter
@Setter
@Builder
@Entity()
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NonNull
    private int id;

    @Enumerated(EnumType.STRING)
    @NonNull
    private ItemType type;

    @NonNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "permission_group_id")
    private PermissionGroup permissionGroup;

    @OneToMany(mappedBy = "parentItem")
    @JsonIgnore
    private List<Item> items;

    @ManyToOne
    @JoinColumn(name = "parent_item_id")
    @JsonIgnore
    private Item parentItem;

    @OneToOne
    @JoinColumn(name = "item", referencedColumnName = "id")
    private File file;

    @Transient
    private int parentItemId;
    @Transient
    private int permissionGroupId;
}