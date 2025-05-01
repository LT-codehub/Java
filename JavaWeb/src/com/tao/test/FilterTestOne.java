package com.tao.test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author LTMAX
 * @version 1.0
 * @className: FilterTestOne
 * @package: com.tao.test
 * @description: TODO
 * @date 2024/1/25 1:31
 */
@WebFilter("/login")
public class FilterTestOne implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterTestOne init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterTestOne doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FilterTestOne doFilter end");
    }

    @Override
    public void destroy() {
        System.out.println("FilterTestOne destroy");
    }
}
