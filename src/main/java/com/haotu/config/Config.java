package com.haotu.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
@Configuration
public class Config {
    @Bean
    public DataSource dataSource() {
        MysqlDataSource datasource = new MysqlDataSource();
        datasource.setUser("root");
        datasource.setPassword("root");
        datasource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        return datasource;
    }
}
