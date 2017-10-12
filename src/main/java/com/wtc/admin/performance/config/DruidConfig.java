package com.wtc.admin.performance.config;

import java.sql.SQLException;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidConfig {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.druid")
	public DruidDataSource dataSource() throws SQLException {
		return new DruidDataSource();
	}
}
