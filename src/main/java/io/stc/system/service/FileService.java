package io.stc.system.service;

import io.stc.system.exception.FileNotFoundException;
import io.stc.system.exception.UserHasNoAccessException;
import io.stc.system.exception.UserUnAuthorizedException;
import io.stc.system.model.File;
import io.stc.system.repo.FileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepo repo;
    private final PermissionService permissionService;

    public List<File> getAll() {
        return repo.findAll();
    }

    public File getById(int id,String email) throws FileNotFoundException, UserUnAuthorizedException, UserHasNoAccessException {
        File file = repo.findById(id).orElse(null);
        if(file == null) throw new FileNotFoundException();
        permissionService.checkHasAccessAndPermissionLevel(email,file.getItem().getId(),false);

        return file;
    }

    public File add(File entity){
        return repo.save(entity);
    }

    public File update(File entity){
        return repo.save(entity);
    }
    public void removeById(int id){
        repo.deleteById(id);
    }

    public File saveFile(MultipartFile multipartFile,int itemId) throws IOException {
        return add(File.builder().binary(multipartFile.getBytes()).itemId(itemId).build());
    }
}
