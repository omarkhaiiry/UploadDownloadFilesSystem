package io.stc.system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.List;

@Getter
@Setter
@Entity()
public class PermissionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NonNull
    private int id;

    @NonNull
    private String groupName;

    @OneToMany(mappedBy = "group")
    @JsonIgnore
    private List<Permission> permissions;
}
