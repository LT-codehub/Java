package com.tao.test;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author LTMAX
 * @version 1.0
 * @className: HelloServlet
 * @package: com.tao.javaweb.service
 * @description: TODO
 * @date 2024/1/22 22:57
 */
public class HelloServlet implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HelloServlet init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HelloServlet service");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet destroy");
    }
}
