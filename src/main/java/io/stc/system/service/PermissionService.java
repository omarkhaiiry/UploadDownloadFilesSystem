package io.stc.system.service;

import io.stc.system.exception.UserHasNoAccessException;
import io.stc.system.exception.UserNotFoundException;
import io.stc.system.exception.UserUnAuthorizedException;
import io.stc.system.model.Permission;
import io.stc.system.model.PermissionGroup;
import io.stc.system.repo.PermissionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionRepo repo;
    private final PermissionGroupService permissionGroupService;

    public List<Permission> getAll() {
        return repo.findAll();
    }

    public Permission getById(int id){
        return repo.findById(id).orElse(null);
    }

    public Permission add(Permission entity){
        PermissionGroup permissionGroup = permissionGroupService.getById(entity.getGroupId());
        entity.setGroup(permissionGroup);
        return repo.save(entity);
    }

    public Permission update(Permission entity){
        return repo.save(entity);
    }

    public void removeById(int id){
        repo.deleteById(id);
    }

    public void checkHasAccessAndPermissionLevel(String email,int groupId,boolean needEditAccess) throws UserHasNoAccessException, UserUnAuthorizedException {
        Permission permission = repo.findByUserEmailAndGroupId(email, groupId);
        if(permission == null){
            throw new UserHasNoAccessException();
        }
        if(needEditAccess && permission.getPermissionLevel().getValue().equals("VIEW")){
            throw new UserUnAuthorizedException();
        }

    }
    public void checkEditPermissionLevel(String email) throws UserNotFoundException, UserUnAuthorizedException {
        Permission permission = repo.findByUserEmail(email);
        if(permission == null){
            throw new UserNotFoundException();
        }
        if(permission.getPermissionLevel().getValue().equals("VIEW")){
            throw new UserUnAuthorizedException();
        }

    }


}
