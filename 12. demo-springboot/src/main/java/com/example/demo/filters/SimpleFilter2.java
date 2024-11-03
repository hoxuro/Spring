package com.example.demo.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@Component
@Order(2)
public class SimpleFilter2 implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(SimpleFilter2.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Inicializando2...");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Filtrando2..." + servletRequest.getLocalAddr() + "::" + servletRequest.getRemoteHost());
      filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("Destruyendo2...");
    }


}
