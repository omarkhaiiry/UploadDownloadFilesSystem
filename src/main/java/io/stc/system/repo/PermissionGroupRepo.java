package io.stc.system.repo;

import io.stc.system.model.PermissionGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionGroupRepo extends JpaRepository<PermissionGroup, Integer> {
}
