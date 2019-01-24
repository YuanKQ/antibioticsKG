package com.iaso.antibiotic;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@MapperScan("mapping")
@ComponentScan(basePackages = "com.iaso")
@EnableWebMvc
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringbootApplication {
    private static Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);

//    @Autowired
//    AntibioticDao antibioticDao;
//
//    @PostConstruct
//    public void test() {
//        antibioticDao.findAllNodeID("sasa");
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
