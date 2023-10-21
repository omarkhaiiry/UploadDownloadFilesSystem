package io.stc.system.controller;

import io.stc.system.exception.PermissionGroupNotFoundException;
import io.stc.system.model.PermissionGroup;
import io.stc.system.service.PermissionGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/permission-group")
public class PermissionGroupController {
    private final PermissionGroupService service;

    @GetMapping()
    public List<PermissionGroup> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public PermissionGroup getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping()
    public PermissionGroup add(@Validated @RequestBody PermissionGroup entity) {
        return service.add(entity);
    }
    @PutMapping()
    public PermissionGroup update(@Validated @RequestBody PermissionGroup entity) throws PermissionGroupNotFoundException {
        return service.update(entity);
    }

    @DeleteMapping("{id}")
    public void removeById(@PathVariable int id) {
        service.removeById(id);
    }
}
