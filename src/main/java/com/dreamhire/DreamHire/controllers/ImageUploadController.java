package com.dreamhire.DreamHire.controllers;

import com.dreamhire.DreamHire.util.FileUploadUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@RequestMapping("api/v1/image")
@RestController
public class ImageUploadController {

    @PostMapping("saveImage")
    public void saveImage(@RequestParam("files")MultipartFile[] files){
        String upoloadDir = "ProfileImageFolder";
        Arrays.asList(files).stream().forEach(file->{
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            System.out.println(fileName);
            try{
                FileUploadUtil.saveImage(upoloadDir,fileName,file);
            }catch (IndexOutOfBoundsException | IOException indexOutOfBoundsException){

            }
        });
    }
}
