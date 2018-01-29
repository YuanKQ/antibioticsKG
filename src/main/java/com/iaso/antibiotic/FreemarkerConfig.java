package com.iaso.antibiotic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FreemarkerConfig {
    private final freemarker.template.Configuration configuration;

    @Autowired
    public FreemarkerConfig (freemarker.template.Configuration configuration) {
        this.configuration = configuration;
        configuration.setSharedVariable("block", new cn.org.rapid_framework.freemarker.directive.BlockDirective());
        configuration.setSharedVariable("extends", new cn.org.rapid_framework.freemarker.directive.ExtendsDirective());
        configuration.setSharedVariable("override", new cn.org.rapid_framework.freemarker.directive.OverrideDirective());
        configuration.setSharedVariable("supper", new cn.org.rapid_framework.freemarker.directive.SuperDirective());
    }
}
