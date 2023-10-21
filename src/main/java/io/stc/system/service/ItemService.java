package io.stc.system.service;

import io.stc.system.exception.InvalidDataStructureException;
import io.stc.system.exception.UserHasNoAccessException;
import io.stc.system.exception.UserUnAuthorizedException;
import io.stc.system.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAll();

    Item getById(int id);

    Item add(Item entity, String email) throws InvalidDataStructureException, UserUnAuthorizedException, UserHasNoAccessException;
}
