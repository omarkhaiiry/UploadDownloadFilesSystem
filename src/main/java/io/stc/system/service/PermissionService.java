package io.stc.system.service;

import io.stc.system.exception.UserHasNoAccessException;
import io.stc.system.exception.UserUnAuthorizedException;
import io.stc.system.model.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> getAll();

    Permission getById(int id);

    Permission add(Permission entity);

    Permission update(Permission entity);

    void removeById(int id);

    void checkHasAccessAndPermissionLevel(String email, int groupId, boolean needEditAccess) throws UserHasNoAccessException, UserUnAuthorizedException;
}
