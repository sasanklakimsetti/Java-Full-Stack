package com.summerpep.todo;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@WebFilter
@Component
@RequestMapping("/**")  // ** means that this filter should be applied on all urls
public class MyLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest  request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest req=(HttpServletRequest) request;
        System.out.println("request: "+req.getRequestURI());
        chain.doFilter(request,response);
    }
}
