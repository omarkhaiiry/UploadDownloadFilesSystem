package io.stc.system.service;

import io.stc.system.exception.InvalidDataStructureException;
import io.stc.system.exception.UserNotFoundException;
import io.stc.system.exception.UserUnAuthorizedException;
import io.stc.system.model.Item;
import io.stc.system.model.PermissionGroup;
import io.stc.system.repo.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepo repo;
    private final PermissionService permissionService;
    private final PermissionGroupService permissionGroupService;

    public List<Item> getAll() {
        return repo.findAll();
    }

    public Item getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Item add(Item entity,String email) throws InvalidDataStructureException, UserNotFoundException, UserUnAuthorizedException {
        permissionService.checkEditPermissionLevel(email);
        Item parent = repo.findById(entity.getParentItemId()).orElse(null);
        checkStructure( entity,parent);
        PermissionGroup permissionGroup = permissionGroupService.getById(entity.getPermissionGroupId());
        entity.setParentItem(parent);
        entity.setPermissionGroup(permissionGroup);
        return repo.save(entity);
    }

    public Item update(Item entity) {
        return repo.save(entity);
    }

    public void removeById(int id) {
        repo.deleteById(id);
    }

    public void checkStructure(Item entity,Item parent) throws InvalidDataStructureException {
        String acceptedType;
        switch (entity.getType().getValue()) {
            case "File" -> acceptedType = "Folder";
            case "Folder" -> acceptedType = "File";
            default -> acceptedType = null;
        }
        if(!((parent == null && acceptedType == null) || (parent != null && parent.getType().getValue().equals(acceptedType)))) {
            throw new InvalidDataStructureException();
        }
    }
}
