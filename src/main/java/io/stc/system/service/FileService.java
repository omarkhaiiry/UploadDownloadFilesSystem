package io.stc.system.service;

import io.stc.system.exception.FileNotFoundException;
import io.stc.system.exception.InvalidDataStructureException;
import io.stc.system.exception.UserHasNoAccessException;
import io.stc.system.exception.UserUnAuthorizedException;
import io.stc.system.model.File;
import io.stc.system.model.Item;
import io.stc.system.model.enums.ItemType;
import io.stc.system.repo.FileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepo repo;
    private final ItemService itemService;
    private final PermissionService permissionService;


    public File getById(int id,String email) throws FileNotFoundException, UserUnAuthorizedException, UserHasNoAccessException {
        File file = repo.findById(id).orElse(null);
        if(file == null) throw new FileNotFoundException();
        permissionService.checkHasAccessAndPermissionLevel(email,file.getItem().getId(),false);
        return file;
    }

    public File add(File entity){
        Item item = itemService.getById(entity.getItemId());
        entity.setItem(item);
        return repo.save(entity);
    }
//
//    public File update(File entity){
//        return repo.save(entity);
//    }
//    public void removeById(int id){
//        repo.deleteById(id);
//    }

    public File saveFile(MultipartFile multipartFile,String name, Integer parentItemId, Integer permissionGroupId,String email) throws IOException, UserUnAuthorizedException, InvalidDataStructureException, UserHasNoAccessException {
        if(permissionGroupId == null)
        {
            Item parent = itemService.getById(parentItemId);
            permissionGroupId = parent.getPermissionGroupId();
        }
        Item item = itemService.add(Item.builder().type(ItemType.FILE).parentItemId(parentItemId).permissionGroupId(permissionGroupId).name(name).build(), email);

        return add(File.builder().binary(multipartFile.getBytes()).item(item).itemId(item.getId()).build());
    }
}
