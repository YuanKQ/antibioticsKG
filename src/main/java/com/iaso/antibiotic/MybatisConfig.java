package com.iaso.antibiotic;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

/**
 * 对应原本的 MyBatis-conf.xml
 */
@Configuration
@PropertySource("classpath*:application.properties")
public class MybatisConfig {

    @Value("classpath*:/mapping/*.xml") private Resource[] mappers;//注入mapper的路径

    @Value("${db.url}") private String dbUrl;
    @Value("${db.username}") private String dbUsername;
    @Value("${db.password}") private String dbPassword;

    @Bean
    DataSource dataSource() {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return configuration -> {
            TransactionFactory transactionFactory = new JdbcTransactionFactory();
            Environment environment = new Environment.Builder("development")
                    .dataSource(dataSource())
                    .transactionFactory(transactionFactory).build();
            configuration.setUseGeneratedKeys(true);
            configuration.setEnvironment(environment);
            configuration.setMapUnderscoreToCamelCase(true);
        };
    }

    @Bean
    org.apache.ibatis.session.Configuration mybatisConfig() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(true);
        configuration.setLazyLoadingEnabled(true);
        configuration.setUseColumnLabel(true);
        configuration.setUseGeneratedKeys(true);
        configuration.setDefaultExecutorType(ExecutorType.SIMPLE);
        configuration.setDefaultStatementTimeout(10000);
        configuration.setLogImpl(Slf4jImpl.class);
        return configuration;
    }

    @Bean
    org.mybatis.spring.SqlSessionFactoryBean sessionFactory() {
        org.mybatis.spring.SqlSessionFactoryBean sessionFactoryBean = new org.mybatis.spring.SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setMapperLocations(mappers);
        sessionFactoryBean.setConfiguration(mybatisConfig());
        return sessionFactoryBean;
    }
}
