package com.yjy.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;

public class HelloServlet implements Servlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;

        String requestBody = IOUtils.toString(req.getInputStream());
        String encodedSign = requestBody.substring(requestBody.indexOf("=") + 1, requestBody.length());
        System.out.println("encodedSign\t" + encodedSign);

        String decodedSign = URLDecoder.decode(encodedSign, "UTF-8");
        System.out.println("decodedSign\t" + decodedSign);

//        String parameterSign = httpServletRequest.getParameter("sign");
//        System.out.println("parameterSign\t" + parameterSign);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
