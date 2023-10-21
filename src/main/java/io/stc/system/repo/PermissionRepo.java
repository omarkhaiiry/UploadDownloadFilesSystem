package io.stc.system.repo;

import io.stc.system.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PermissionRepo extends JpaRepository<Permission, Integer> {

    @Query(value = "SELECT * FROM permission p WHERE p.user_email = ?1 AND p.group_id = ?2", nativeQuery = true)
    Permission findByUserEmailAndGroupId(String email, int groupId);
}
