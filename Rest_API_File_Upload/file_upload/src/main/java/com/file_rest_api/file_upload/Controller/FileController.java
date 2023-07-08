package com.file_rest_api.file_upload.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.file_rest_api.file_upload.Entity.File;
import com.file_rest_api.file_upload.Entity.FileInfo;
import com.file_rest_api.file_upload.Service.FileService;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    // upload single file
    @PostMapping("/upload")
    public ResponseEntity<FileInfo> saveFile(@RequestParam("file") MultipartFile multipartFile) {
        File file = fileService.saveFile(multipartFile);

        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path("" + file.getId())
                .toUriString();

        FileInfo fileInfo = new FileInfo(file.getId(), file.getFileName(), file.getFileType(), url);

        return ResponseEntity.of(Optional.of(fileInfo));

    }

    // upload multiple files
    @PostMapping("/uploads")
    public ResponseEntity<List<FileInfo>> saveAllFile(@RequestParam("files") MultipartFile[] multipartFiles) {
        List<FileInfo> list = new ArrayList<FileInfo>();

        for (MultipartFile temp : multipartFiles) {

            File file = fileService.saveFile(temp);

            String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path("" + file.getId())
                    .toUriString();

            FileInfo fileInfo = new FileInfo(file.getId(), file.getFileName(), file.getFileType(), url);

            list.add(fileInfo);
        }

        return ResponseEntity.of(Optional.of(list));
    }

    // get download single file
    @GetMapping("/download/{fileid}")
    public ResponseEntity<ByteArrayResource> downnloadFile(@PathVariable int fileid) {

        File file = fileService.getFile(fileid).get();

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + file.getFileName() + "\"")
                .body(new ByteArrayResource(file.getData()));
    }
}
