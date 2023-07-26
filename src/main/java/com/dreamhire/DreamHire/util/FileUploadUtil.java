package com.dreamhire.DreamHire.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
    public static void saveImage(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadpath = Paths.get("E:\\New Projects\\Group Project 2\\BackEnd\\DreamHire\\src\\main\\resources\\static" +uploadDir);
        if(!Files.exists(uploadpath)){
            Files.createDirectories(uploadpath);
        }
        try(InputStream inputStream= multipartFile.getInputStream()){
            Path filepath = uploadpath.resolve(fileName);
            Files.copy(inputStream, filepath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException ioException) {

        }

    }
}
