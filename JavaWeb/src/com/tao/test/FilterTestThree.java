package com.tao.test;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author LTMAX
 * @version 1.0
 * @className: FilterTestTherr
 * @package: com.tao.test
 * @description: TODO
 * @date 2024/1/25 1:32
 */
public class FilterTestThree implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterTestThree init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterTestThree doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FilterTestThree doFilter after");
    }

    @Override
    public void destroy() {
        System.out.println("FilterTestThree destroy");
    }
}
