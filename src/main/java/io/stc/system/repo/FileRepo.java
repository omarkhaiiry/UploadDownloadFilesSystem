package io.stc.system.repo;

import io.stc.system.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<File, Integer> {
}
