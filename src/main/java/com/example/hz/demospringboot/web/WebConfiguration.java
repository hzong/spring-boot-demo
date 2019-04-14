package com.example.hz.demospringboot.web;

import com.example.hz.demospringboot.conf.NeoProperties;
import org.apache.catalina.filters.RemoteIpFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Classname WebConfiguration
 * @Description TODO
 * @Date 2019-03-05 00:29
 * @Created by hzong
 */
@Configuration
public class WebConfiguration {
    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfiguration.class);
    

    @Autowired
    private NeoProperties neoProperties;

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }

    public class MyFilter implements Filter {
        @Override
        public void destroy() {
            // TODO Auto-generated method stub
        }

        @Override
        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
                throws IOException, ServletException {
            // TODO Auto-generated method stub
            HttpServletRequest request = (HttpServletRequest) srequest;
            
            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("请求的地址为：【{}】",request.getRequestURI());
            }
            
            System.out.println(neoProperties.getTitle()+"this is MyFilter,url :"+request.getRequestURI());
            filterChain.doFilter(srequest, sresponse);
        }

        @Override
        public void init(FilterConfig arg0) throws ServletException {
            // TODO Auto-generated method stub
        }
    }

}
