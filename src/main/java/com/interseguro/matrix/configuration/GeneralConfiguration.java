//package com.interseguro.matrix.configuration;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//import javax.sql.DataSource;
//
//@Configuration
////@PropertySource("classpath:application.properties")
//public class GeneralConfiguration {
//
//    @Value("${jdbc.url}")
//    private String jdbcUrl;
//
//    @Value("${driver}")
//    private String driver;
//
//    @Value("${username}")
//    private String username;
//
//    @Value("${password}")
//    private String password;
//
//    @Bean
//    public DataSource dataSource(){
//        /*
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.h2.Driver");
//        dataSourceBuilder.url("jdbc:h2:mem:testdb;NON_KEYWORDS=USER");
//        dataSourceBuilder.username("sa");
//        dataSourceBuilder.password("");
//        return dataSourceBuilder.build();
//        */
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName(driver);
//        dataSourceBuilder.url(jdbcUrl);
//        dataSourceBuilder.username(username);
//        dataSourceBuilder.password(password);
//        return dataSourceBuilder.build();
//
//    }
//}
