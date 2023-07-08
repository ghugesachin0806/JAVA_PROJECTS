package com.file_rest_api.file_upload.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.file_rest_api.file_upload.Entity.File;

public interface FileRepository extends JpaRepository<File,Integer>{
    
}
