package com.yjy.resource;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Date;

public class ClassPathResourceTest {

    @Test
    public void read() throws IOException {
        Resource resource = new ClassPathResource("1.txt");
        System.out.println("filename: " + resource.getFilename());
        System.out.println("exists: " + resource.exists());
        System.out.println("contentLength: " + resource.contentLength());
        System.out.println("description: " + resource.getDescription());
        System.out.println("lastModified: " + new Date(resource.lastModified()).toLocaleString());
        System.out.println("isReadable: " + resource.isReadable());
        System.out.println("isOpen: " + resource.isOpen());
        System.out.println("content: " + FileUtils.readFileToString(resource.getFile()));
    }
}
