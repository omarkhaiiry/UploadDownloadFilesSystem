package io.stc.system.service;

import io.stc.system.exception.PermissionGroupNotFoundException;
import io.stc.system.model.PermissionGroup;
import io.stc.system.repo.PermissionGroupRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionGroupServiceImpl implements PermissionGroupService {

    private final PermissionGroupRepo repo;


    @Override
    public List<PermissionGroup> getAll() {
        return repo.findAll();
    }

    @Override
    public PermissionGroup getById(int id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public PermissionGroup add(PermissionGroup entity){
        return repo.save(entity);
    }

    @Override
    public PermissionGroup update(PermissionGroup entity) throws PermissionGroupNotFoundException {
        PermissionGroup permissionGroup = getById(entity.getId());
        if(permissionGroup == null) throw new PermissionGroupNotFoundException();
        return repo.save(entity);
    }

    @Override
    public void removeById(int id){
        repo.deleteById(id);
    }
}
