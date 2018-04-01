/****************************************************
author: Guo Jiayu, potplus@live.com, http://gjyu.me
the damianX back-end software is a private property
Copyright 2018 Guo Jiayu
*****************************************************/
package com.damx.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import java.io.IOException;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.apache.commons.io.IOUtils;
import java.net.URLEncoder;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//
//@RestController
//@RequestMapping("/storage/")
public class BucketController {

    private AmazonClient amazonClient;

    @Autowired
    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

//    @PostMapping("/uploadFile")
//    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
//        return this.amazonClient.uploadFile(file);
//    }

    public String uploadFile(MultipartFile file) {
        return this.amazonClient.uploadFile(file);
    }

//    @DeleteMapping("/deleteFile")
    public String deleteFile(String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }

//    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String key) throws IOException {

        S3Object s3Object = amazonClient.download(amazonClient.getBucketName(), key);

        S3ObjectInputStream objectInputStream = s3Object.getObjectContent();

        byte[] bytes = IOUtils.toByteArray(objectInputStream);

        String fileName = URLEncoder.encode(key, "UTF-8").replaceAll("\\+", "%20");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentLength(bytes.length);
        httpHeaders.setContentDispositionFormData("attachment", fileName);

        return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
    }

    public String uploadFileWithName(MultipartFile file, String name)
    {
        return this.amazonClient.uploadFilewithName(file, name);
    }

}
