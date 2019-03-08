package com.cetc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据库配置
 */
@Configuration
public class DataSourceConfiguration {

    /**
     *  第一个数据连接，默认优先级最高
     * @return
     */
    @Bean(name = "dataSourceFirst")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSource dataSourceFirst() {
        //这种方式的配置默认只满足spring的配置方式，如果使用其他数据连接（druid）,需要自己独立获取配置
        return DataSourceBuilder.create().build();
    }

    /**
     * 第二个数据源
     * @return
     */
    @Bean(name = "dataSourceSecond")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource dataSourceSecond() {
        return DataSourceBuilder.create().build();
    }
}
