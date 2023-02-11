package com.uniyaz.springboot.utility.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

//@Configuration
public class HibernateConfig {

    @Bean
    public LocalSessionFactoryBean factoryBean2(DataSource dataSource, Properties hibernateProperties, String packagesToScan) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(hibernateProperties);
        factoryBean.setPackagesToScan(packagesToScan);
        return factoryBean;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/phone");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("Meliksahse28");
        return basicDataSource;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.pool_size", "10");
        properties.setProperty("hibernate.current_session_context_class", "thread");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.connection.autocommit", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");

        return properties;
    }

    @Bean
    public String packagesToScan() {
        return "com.uniyaz.springboot.core.domain";
    }
}
