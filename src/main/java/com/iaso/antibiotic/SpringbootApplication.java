package com.iaso.antibiotic;


import com.iaso.antibiotic.dao.AntibioticDao;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan("mapping")
@ComponentScan(basePackages = "com.iaso")
@EnableWebMvc
public class SpringbootApplication {
    private static Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);

    @Autowired
    AntibioticDao antibioticDao;

    @PostConstruct
    public void test() {
        antibioticDao.findAllNodeID("sasa");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
