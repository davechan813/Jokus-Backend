/****************************************************
 author: Guo Jiayu, potplus@live.com, http://gjyu.me
 the damianX back-end software is a private property
 Copyright 2018 Guo Jiayu
 *****************************************************/
package com.damx.persistencyUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
public class S3Delegate {

    @Autowired
    S3Services s3Services;

    public void uploadFile(File f, String name)
    {
        s3Services.uploadFile(f, name);
    }

    public void downloadFile(String name)
    {
        s3Services.downloadFile(name);
    }
}
