package io.stc.system.controller;

import io.stc.system.exception.FileNotFoundException;
import io.stc.system.exception.UserHasNoAccessException;
import io.stc.system.exception.UserUnAuthorizedException;
import io.stc.system.model.File;
import io.stc.system.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/file")
public class FileController {
    private final FileService service;

    @GetMapping()
    public List<File> getAll() {
        return service.getAll();
    }

    @DeleteMapping("{id}")
    public void removeById(@PathVariable int id) {
        service.removeById(id);
    }

    @GetMapping("{id}")
    public byte[] downloadFile(@PathVariable int id, @RequestParam String email) throws FileNotFoundException, UserUnAuthorizedException, UserHasNoAccessException {
        File file = service.getById(id,email);
        return file.getBinary();
    }
    @PostMapping()
    public File uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("itemId") int itemId) throws IOException {
        return service.saveFile(file,itemId);
    }
}

