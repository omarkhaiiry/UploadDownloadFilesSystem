package io.stc.system.controller;

import io.stc.system.model.Permission;
import io.stc.system.service.PermissionService;
import io.stc.system.service.PermissionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/permission")
public class PermissionController {
    private final PermissionService service;

    @GetMapping()
    public List<Permission> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Permission getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping()
    public Permission add(@Validated @RequestBody Permission entity) {
        return service.add(entity);
    }

    @DeleteMapping("{id}")
    public void removeById(@PathVariable int id) {
        service.removeById(id);
    }
}
