package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR = "D:\\springboot\\bootrestbook\\src\\main\\resources\\static\\image";

    public boolean uploadFile(MultipartFile f){
        boolean flag = false;

        try {
            // InputStream is = f.getInputStream();
            // byte data[] = new byte[is.available()];
            // is.read(data);

            // //write
            // FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"\\"+f.getOriginalFilename());
            // fos.write(data);

            // fos.flush();
            // fos.close();
            // flag = true;

            Files.copy(f.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+f.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            flag = true;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return flag;
    }
}
