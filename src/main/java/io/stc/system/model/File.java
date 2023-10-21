package io.stc.system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.NonNull;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity()
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private int id;

    @Lob
    @Column(name = "\"binary\"")
    @NonNull
    private byte[] binary;

    @OneToOne
    @JoinColumn(name = "itemId", referencedColumnName = "id")
    @JsonIgnore
    @NonNull
    private Item item;

    @Transient
    private Integer itemId;
}