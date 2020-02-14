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

@Controller
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if(file.isEmpty()) {
            return "Upload fail. Please select correct file";
        }

        String fileName = file.getOriginalFilename();
        // TODO: need to upload server?
        String filePath = "D:\\receive/";
        File dest = new File(filePath + fileName);

        if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            LOGGER.info("Upload Success");
            return "Upload Success";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "Upload fail.";
    }

}
