package com.iaso.antibiotic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 对应原本的 mvc-dispatcher.xml
 */
@Configuration
public class mvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/", "/images/**");
        registry.addResourceHandler("/img/", "/img/**");
        registry.addResourceHandler("/src/", "/src/**");
        registry.addResourceHandler("/dist/", "/dist/**");
        registry.addResourceHandler("/fonts/", "/fonts/**");
        registry.addResourceHandler("/css/", "/css/**");
        registry.addResourceHandler("/js/", "/js/**");
    }

    @Bean
    FreeMarkerViewResolver resolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
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
    InternalResourceViewResolver servletResolver() {
        return new InternalResourceViewResolver("WEB-INF/JSP/", ".jsp");
    }

    @Bean
    FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("WEB-INF/FTL/");
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
    cn.org.rapid_framework.freemarker.directive.BlockDirective blockDirective() {
        return new cn.org.rapid_framework.freemarker.directive.BlockDirective();
    }

    @Bean
    cn.org.rapid_framework.freemarker.directive.ExtendsDirective extendsDirective() {
        return new cn.org.rapid_framework.freemarker.directive.ExtendsDirective();
    }

    @Bean
    cn.org.rapid_framework.freemarker.directive.OverrideDirective overrideDirective() {
        return new cn.org.rapid_framework.freemarker.directive.OverrideDirective();
    }

    @Bean
    cn.org.rapid_framework.freemarker.directive.SuperDirective superDirective() {
        return new cn.org.rapid_framework.freemarker.directive.SuperDirective();
    }

}
