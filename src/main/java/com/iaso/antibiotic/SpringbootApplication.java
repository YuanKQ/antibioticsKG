package com.iaso.antibiotic;


import com.iaso.antibiotic.dao.AntibioticDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan("com.iaso.mapping")
@ComponentScan(basePackages = "com.iaso")
public class SpringbootApplication {
    AntibioticDao antibioticDao;
    @PostConstruct
    public void test() {
        antibioticDao.findAllNodeID("asaa");
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Autowired
    public SpringbootApplication setAntibioticDao(AntibioticDao antibioticDao) {
        this.antibioticDao = antibioticDao;
        return this;
    }
}
