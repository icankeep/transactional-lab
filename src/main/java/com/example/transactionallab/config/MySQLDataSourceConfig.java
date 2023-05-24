package com.example.transactionallab.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author passer
 * @time 2023/5/24 08:42
 */
@Configuration
public class MySQLDataSourceConfig {


    @ConfigurationProperties("spring.datasource-test1")
    @Bean("test1DataSource")
    public DataSource getTest1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @ConfigurationProperties("spring.datasource-test2")
    @Bean("test2DataSource")
    public DataSource getTest2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("test1JdbcTemplate")
    public JdbcTemplate getTest1JdbcTemplate(@Qualifier("test1DataSource")DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Primary
    @Bean("test2JdbcTemplate")
    public JdbcTemplate getTest2JdbcTemplate(@Qualifier("test2DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
