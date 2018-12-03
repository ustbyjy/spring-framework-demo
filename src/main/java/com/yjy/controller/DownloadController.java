package com.yjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class DownloadController {

    @RequestMapping(value = "/download", method = {RequestMethod.GET, RequestMethod.POST})
    public void download(HttpServletResponse response) {
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream("D:\\QMDownload\\apache-tomcat-8.5.20-windows-x64.zip"));
            int fileLength = inputStream.available();
            byte[] buffer = new byte[fileLength];
            inputStream.read(buffer);
            inputStream.close();

            response.reset();
            response.setHeader("Content-Length", "" + fileLength);
            response.setHeader("Content-Disposition", "attachment; filename=apache-tomcat-8.5.20-windows-x64.zip");
            response.setContentType("application/octet-stream");

            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            outputStream.write(buffer);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
