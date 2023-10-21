package io.stc.system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.stc.system.model.enums.PermissionLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@Entity()
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NonNull
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
    private String userEmail;

    @NonNull
    @Enumerated(EnumType.STRING)
    private PermissionLevel permissionLevel;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonIgnore
    @NonNull
    private PermissionGroup group;

    @Transient
    private Integer groupId;

}
