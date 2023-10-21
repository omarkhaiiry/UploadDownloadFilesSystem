package io.stc.system.controller;

import io.stc.system.exception.FileNotFoundException;
import io.stc.system.exception.InvalidDataStructureException;
import io.stc.system.exception.UserHasNoAccessException;
import io.stc.system.exception.UserUnAuthorizedException;
import io.stc.system.model.File;
import io.stc.system.service.FileService;
import io.stc.system.service.FileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/file")
public class FileController {
    private final FileService service;

    @GetMapping("{id}")
    public byte[] downloadFile(@PathVariable int id, @RequestParam String email) throws FileNotFoundException, UserUnAuthorizedException, UserHasNoAccessException {
        File file = service.getById(id,email);
        return file.getBinary();
    }
    @PostMapping()
    public File uploadFile(@RequestParam("file") MultipartFile file,@RequestParam() String name,@RequestParam() int parentItemId,@RequestParam(required = false) Integer permissionGroupId, @RequestParam String email) throws IOException, UserUnAuthorizedException, InvalidDataStructureException, UserHasNoAccessException {
        return service.saveFile(file,name,parentItemId,permissionGroupId,email);
    }
}

