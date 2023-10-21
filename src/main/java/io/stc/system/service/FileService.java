package io.stc.system.service;

import io.stc.system.exception.FileNotFoundException;
import io.stc.system.exception.InvalidDataStructureException;
import io.stc.system.exception.UserHasNoAccessException;
import io.stc.system.exception.UserUnAuthorizedException;
import io.stc.system.model.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    File getById(int id, String email) throws FileNotFoundException, UserUnAuthorizedException, UserHasNoAccessException;

    File add(File entity);

    File saveFile(MultipartFile multipartFile, String name, Integer parentItemId, Integer permissionGroupId, String email) throws IOException, UserUnAuthorizedException, InvalidDataStructureException, UserHasNoAccessException;
}
