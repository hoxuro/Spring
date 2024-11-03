package com.heriamezcua.accountserviceapi.interceptors;

import com.heriamezcua.accountserviceapi.AccountServiceAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Component
public class AccountsInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceAPI.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();

        if (requestURI.startsWith("/api/accounts")) {
            // Obtaining and registering the HTTP method
            String method = request.getMethod();

            // Obtaining the query params
            StringBuilder queryParams = new StringBuilder();
            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String paramValue = request.getParameter(paramName);
                queryParams.append(paramName).append("=").append(paramValue).append("&");
            }
            // Delete the last & if exists
            if (queryParams.length() > 0) {
                queryParams.deleteCharAt(queryParams.length() - 1);
            }

            // Obtaining the origin IP
            String clientIp = request.getRemoteAddr();

            // Registering the info in the log
            logger.info("Request to /api/accounts - Method: " + method
                    + ", Path: " + requestURI
                    + ", QueryParams: " + queryParams
                    + ", IP: " + clientIp);

            // Adding a response header
            response.addHeader("accounts-request-reviewed", "true");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}