package com.iaso.antibiotic;


import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

/**
 * 对应原本的 MyBatis-conf.xml
 * https://blog.lanyonm.org/articles/2014/04/21/spring-4-mybatis-java-config.html
 * 关键词: minimum springboot application
 *
 */
@Configuration
@PropertySource("classpath:application.properties")//PropertySource注解用于指定配置文件(.properties文件),以便下面的@Value注解获取配置项
public class MybatisConfig {

    //这里的value注解用于配置resource的路径,等同于
    //private Resource[] mappers = new PathMatchingResourcePatternResolver(this.getClass().getClassLoader()).getResources("classpath:/mapping/*.xml");
    //注入成功后mappers实际上是一个文件数组,文件被抽象成 Resource
    @Value("classpath*:/mapping/*.xml") private Resource[] mappers;//注入mapper的路径

    //这里的value注解用于从application.properties文件当中获取配置项,
    @Value("${db.url}") private String dbUrl;
    @Value("${db.username}") private String dbUsername;
    @Value("${db.password}") private String dbPassword;


    /**
     * 配置数据源
     *
     * @return
     */
    @Bean
    DataSource dataSource() {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    /**
     * 配置Mybatis特性
     *
     * @return
     */
    @Bean
    org.apache.ibatis.session.Configuration mybatisConfiguration() {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();

        Environment environment = new Environment.Builder("development")
                .dataSource(dataSource())//配置DataSource
                .transactionFactory(transactionFactory).build();

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setEnvironment(environment);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(true);//开启缓存
        configuration.setLazyLoadingEnabled(true);//开启懒加载
        configuration.setUseColumnLabel(true);//
        configuration.setUseGeneratedKeys(true);
        configuration.setDefaultExecutorType(ExecutorType.SIMPLE);
        configuration.setDefaultStatementTimeout(10000);
        configuration.setLogImpl(Slf4jImpl.class);
        return configuration;
    }

    /**
     * {@link org.mybatis.spring.SqlSessionFactoryBean}使Spring可以在需要的时候自动获取一个 {@link org.apache.ibatis.session.SqlSession}
     * @return
     */
    @Bean
    public org.mybatis.spring.SqlSessionFactoryBean sessionFactory() {
        org.mybatis.spring.SqlSessionFactoryBean sessionFactoryBean = new org.mybatis.spring.SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setMapperLocations(mappers);//关键:设置扫描mapper的路径
        sessionFactoryBean.setConfiguration(mybatisConfiguration());
        return sessionFactoryBean;
    }
}
