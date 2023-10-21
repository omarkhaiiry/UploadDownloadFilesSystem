package io.stc.system.controller;

import io.stc.system.exception.InvalidDataStructureException;
import io.stc.system.exception.UserHasNoAccessException;
import io.stc.system.exception.UserNotFoundException;
import io.stc.system.exception.UserUnAuthorizedException;
import io.stc.system.model.Item;
import io.stc.system.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService service;

    @GetMapping()
    public List<Item> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Item getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping()
    public Item add(@Validated @RequestBody Item entity, @RequestParam String email) throws InvalidDataStructureException, UserNotFoundException, UserUnAuthorizedException, UserHasNoAccessException {
        return service.add(entity, email);
    }
}
