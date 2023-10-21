package io.stc.system.service;

import io.stc.system.exception.InvalidDataStructureException;
import io.stc.system.exception.UserHasNoAccessException;
import io.stc.system.exception.UserUnAuthorizedException;
import io.stc.system.model.Item;
import io.stc.system.model.PermissionGroup;
import io.stc.system.repo.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepo repo;
    private final PermissionService permissionService;
    private final PermissionGroupServiceImpl permissionGroupService;

    @Override
    public List<Item> getAll() {
        return repo.findAll();
    }

    @Override
    public Item getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Item add(Item entity, String email) throws InvalidDataStructureException, UserUnAuthorizedException, UserHasNoAccessException {
        Item parent = repo.findById(entity.getParentItemId()).orElse(null);
        checkStructure(entity, parent);
        if (parent != null) {
            permissionService.checkHasAccessAndPermissionLevel(email, parent.getPermissionGroup().getId(), true);
        }
        PermissionGroup permissionGroup = permissionGroupService.getById(entity.getPermissionGroupId());
        entity.setParentItem(parent);
        entity.setPermissionGroup(permissionGroup);
        return repo.save(entity);
    }

    public void checkStructure(Item entity, Item parent) throws InvalidDataStructureException {
        String acceptedType;
        switch (entity.getType().getValue()) {
            case "File" -> acceptedType = "Folder";
            case "Folder" -> acceptedType = "Space";
            default -> acceptedType = null;
        }
        if (!((parent == null && acceptedType == null) || (parent != null && parent.getType().getValue().equals(acceptedType)))) {
            throw new InvalidDataStructureException();
        }
    }
}
