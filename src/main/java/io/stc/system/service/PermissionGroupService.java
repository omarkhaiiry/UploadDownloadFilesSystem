package io.stc.system.service;

import io.stc.system.model.PermissionGroup;
import io.stc.system.repo.PermissionGroupRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionGroupService {

    private final PermissionGroupRepo repo;

    public List<PermissionGroup> getAll() {
        return repo.findAll();
    }

    public PermissionGroup getById(int id){
        return repo.findById(id).orElse(null);
    }

    public PermissionGroup add(PermissionGroup entity){
        return repo.save(entity);
    }

    public PermissionGroup update(PermissionGroup entity){
        return repo.save(entity);
    }

    public void removeById(int id){
        repo.deleteById(id);
    }
}
