package io.stc.system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.stc.system.model.enums.ItemType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.List;

@Getter
@Setter
@Entity()
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
    private Integer parentItemId;
    @Transient
    private Integer permissionGroupId;
}