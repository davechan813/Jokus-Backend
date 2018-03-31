/****************************************************
 author: Guo Jiayu, potplus@live.com, http://gjyu.me
 the damianX back-end software is a private property
 Copyright 2018 Guo Jiayu
 *****************************************************/
package com.damx.mvc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.damx.persistencyUtil.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.*;
//@RestController
public class IOTestController {
////    @RequestMapping(value="/findByLastName", method = RequestMethod.POST)
////    public @ResponseBody
////    List<User> findUserByLastName(@RequestParam String name)
////    {
////        return userRepository.findByLastName(name);
////    }
//
//    S3Delegate s3 = new S3Delegate();
//
//    @RequestMapping(value="/upload", method = RequestMethod.POST)
//    public @ResponseBody String uploadFile(@RequestParam MultipartFile f, @RequestParam String name) throws IOException
//    {
//        if (f == null)
//            return "1";
//        File file = convert(f);
//        if(file == null)
//            return "2";
//        s3.uploadFile(file, name);
//        return "0";
//    }
//
//    @RequestMapping(value="/download", method = RequestMethod.POST)
//    public @ResponseBody String uploadFile(@RequestParam String name)
//    {
//        s3.downloadFile(name);
//        return "0";
//    }
//
////    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException
////    {
////        File convFile = new File( multipart.getOriginalFilename());
////        multipart.transferTo(convFile);
////        return convFile;
////    }
//    public static File convert(MultipartFile file) throws IOException {
//        File convFile = new File(file.getOriginalFilename());
//        convFile.createNewFile();
//        FileOutputStream fos = new FileOutputStream(convFile);
//        fos.write(file.getBytes());
//        fos.close();
//        return convFile;
//    }
}
