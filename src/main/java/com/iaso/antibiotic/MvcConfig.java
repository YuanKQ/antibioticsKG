package com.iaso.antibiotic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 对应原本的 mvc-dispatcher.xml
 */
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

    private static Logger logger = LoggerFactory.getLogger(MvcConfig.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/", "/images/**").addResourceLocations("classpath:/images/");
        registry.addResourceHandler("/img/", "/img/**").addResourceLocations("classpath:/img/");
        registry.addResourceHandler("/src/", "/src/**").addResourceLocations("classpath:/src/");
        registry.addResourceHandler("/dist/", "/dist/**").addResourceLocations("classpath:/dist/");
        registry.addResourceHandler("/fonts/", "/fonts/**").addResourceLocations("classpath:/fonts/");
        registry.addResourceHandler("/css/", "/css/**").addResourceLocations("classpath:/css/");
        registry.addResourceHandler("/js/*").addResourceLocations("classpath:/js/");

        registry.setOrder(-1); //必须要把order设为-1，即在controller之前解析
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(freemarkerResolver());
        registry.viewResolver(servletResolver());
//        registry.order(Ordered.HIGHEST_PRECEDENCE);
    }

    @Bean
    ViewResolver freemarkerResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setViewClass(org.springframework.web.servlet.view.freemarker.FreeMarkerView.class);
        resolver.setCache(false);
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        resolver.setContentType("text/html;charset=UTF-8");
        resolver.setRequestContextAttribute("request");
        resolver.setExposeSpringMacroHelpers(true);
        resolver.setExposeRequestAttributes(true);
        resolver.setExposeSessionAttributes(true);
        return resolver;
    }


    @Bean
    FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();

        configurer.setTemplateLoaderPath("classpath:/WEB-INF/FTL/");

        Properties freemarkerSettings = new Properties();
        freemarkerSettings.setProperty("template_update_delay", "5");
        freemarkerSettings.setProperty("default_encoding", "UTF-8");
        freemarkerSettings.setProperty("locale", "UTF-8");
        freemarkerSettings.setProperty("datetime_format", "yyyy-MM-dd HH:mm:ss");
        freemarkerSettings.setProperty("time_format", "HH:mm:ss");
        freemarkerSettings.setProperty("number_format", "0.####");
        freemarkerSettings.setProperty("boolean_format", "true,false");
        freemarkerSettings.setProperty("whitespace_stripping", "true");
        freemarkerSettings.setProperty("tag_syntax", "auto_detect");
        freemarkerSettings.setProperty("url_escaping_charset", "UTF-8");
        freemarkerSettings.setProperty("classic_compatible", "true");
        configurer.setFreemarkerSettings(freemarkerSettings);

        Map<String, Object> freemarkerVariables = new HashMap<>();
        freemarkerVariables.put("extends", "extendsDirective");
        freemarkerVariables.put("override", "overrideDirective");
        freemarkerVariables.put("block", "blockDirective");
        freemarkerVariables.put("super", "superDirective");

        configurer.setFreemarkerVariables(freemarkerVariables);

        return configurer;
    }


    @Bean
    ViewResolver servletResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver("/WEB-INF/JSP/", ".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
