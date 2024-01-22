package com.tao.test;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author LTMAX
 * @version 1.0
 * @className: HiServlet
 * @package: com.tao.javaweb.service
 * @description: TODO
 * @date 2024/1/22 23:14
 */
@WebServlet("/hi")
public class HiServlet implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HiServlet初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("HiServlet被访问");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("HiServlet销毁");
    }


}
