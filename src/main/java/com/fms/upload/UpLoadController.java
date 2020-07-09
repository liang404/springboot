package com.fms.upload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author liang
 * @create 2020/6/27 1:43
 */
@Controller
public class UpLoadController {
    //        创建一个数组用来放置上传图片类型的contentType
    private static final List<String> CONTENT_TYPES = Arrays.asList("image/jpeg","application/x-jpg");

    @PostMapping("upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file){
//        上传到文件夹
        String path="B:\\uploadimage\\";
        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
//        校验文件的后缀是否为图片
        String contentType = file.getContentType();
        if (!CONTENT_TYPES.contains(contentType)){
            System.out.println("cuowu");
            return ResponseEntity.badRequest().build();
        }
//        校验文件内容是否合格
        try {
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage == null){
                System.out.println("couwu2");
                return ResponseEntity.badRequest().build();
            }
            String filename = path+ UUID.randomUUID().toString().replace("-","")+originalFilename;
            file.transferTo(new File(filename));
            return ResponseEntity.status(HttpStatus.CREATED).body(filename);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

}
