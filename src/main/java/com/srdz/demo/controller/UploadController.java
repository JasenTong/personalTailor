package com.srdz.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("files") List<MultipartFile> files) {

        // TODO: need to upload server?
        String filePath = "/Users/zfzhou/test/";

        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if(file.isEmpty()) {
                return "上传第" + (i++) + "个文件失败";
            }

            String fileName = file.getOriginalFilename();
            File dest = new File(filePath + fileName);

            if(!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }

            try {
                file.transferTo(dest);
                LOGGER.info("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                LOGGER.error(e.toString(), e);
                return "上传第" + (i++) + "个文件失败";
            }
        }
        return "上传成功";
    }

}
