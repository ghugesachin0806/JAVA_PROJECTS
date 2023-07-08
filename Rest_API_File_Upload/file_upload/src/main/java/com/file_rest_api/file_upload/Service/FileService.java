package com.file_rest_api.file_upload.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.file_rest_api.file_upload.Entity.File;
import com.file_rest_api.file_upload.Repository.FileRepository;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    // store the file in database
    public File saveFile(MultipartFile multipartFile) {
        String name = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        try {
            File file = new File(name, multipartFile.getContentType(), multipartFile.getBytes());
            return fileRepository.save(file);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

    // get the file from database
    public Optional<File> getFile(int id) {
        return fileRepository.findById(id);
    }
}
