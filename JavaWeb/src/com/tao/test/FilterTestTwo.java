package com.tao.test;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author LTMAX
 * @version 1.0
 * @className: FilterTestTwo
 * @package: com.tao.test
 * @description: TODO
 * @date 2024/1/25 1:32
 */
public class FilterTestTwo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterTestTwo init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterTestTwo doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FilterTestTwo doFilter after");
    }

    @Override
    public void destroy() {
        System.out.println("FilterTestTwo destroy");
    }
}
