package io.stc.system.repo;

import io.stc.system.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Integer> {
}
