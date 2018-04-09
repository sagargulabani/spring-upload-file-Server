package com.example.demo;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

  @RequestMapping(method = RequestMethod.POST)
  public String handleFileUpload(
          @RequestParam("file") MultipartFile multipartFile) throws IOException {
      String name = multipartFile.getOriginalFilename();
      System.out.println("File name: "+name);
      //todo save to a file via multipartFile.getInputStream()
      byte[] bytes = multipartFile.getBytes();
      System.out.println("File uploaded content:\n" + new String(bytes));
      return "file uploaded";
  }
}