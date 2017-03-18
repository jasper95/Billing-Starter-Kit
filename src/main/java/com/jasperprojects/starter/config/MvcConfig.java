package com.jasperprojects.starter.config;


import com.github.dandelion.datatables.extras.spring3.ajax.DatatablesCriteriasMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

import java.util.List;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new DatatablesCriteriasMethodArgumentResolver());
    }

    @Bean
    public JasperReportsViewResolver reportsResolver(){
        JasperReportsViewResolver resolver  = new JasperReportsViewResolver();
        resolver.setPrefix("classpath:jasperreports");
        resolver.setSuffix(".jasper");
        resolver.setViewNames("rpt_*");
        resolver.setOrder(0);
        resolver.setViewClass(JasperReportsMultiFormatView.class);
        return resolver;
    }

}