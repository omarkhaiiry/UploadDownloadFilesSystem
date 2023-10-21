package io.stc.system.service;

import io.stc.system.exception.PermissionGroupNotFoundException;
import io.stc.system.model.PermissionGroup;

import java.util.List;

public interface PermissionGroupService {
    List<PermissionGroup> getAll();

    PermissionGroup getById(int id);

    PermissionGroup add(PermissionGroup entity);

    PermissionGroup update(PermissionGroup entity) throws PermissionGroupNotFoundException;

    void removeById(int id);
}
