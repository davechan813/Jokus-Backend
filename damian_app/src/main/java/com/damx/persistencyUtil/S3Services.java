/****************************************************
 author: Guo Jiayu, potplus@live.com, http://gjyu.me
 the damianX back-end software is a private property
 Copyright 2018 Guo Jiayu
 *****************************************************/
package com.damx.persistencyUtil;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;

import java.io.File;
public interface S3Services {
    public void downloadFile(String keyName);
    public void uploadFile(File f, String name);
        }
