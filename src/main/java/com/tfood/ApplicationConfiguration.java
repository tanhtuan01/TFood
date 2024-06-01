package com.tfood;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.tfood"})
@PropertySource(value = {"classpath:db.properties"})
public class ApplicationConfiguration implements WebMvcConfigurer {
    @Autowired
    Environment enviroment;

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(enviroment.getProperty("driver"));
        dataSource.setUrl(enviroment.getProperty("url"));
        // dataSource.setUsername(enviroment.getProperty("username"));
        dataSource.setUsername("root");
//        dataSource.setPassword(enviroment.getProperty("password"));
        dataSource.setPassword("");
        // for sql server
//        dataSource.setDriverClassName(enviroment.getProperty("driver"));
//		dataSource.setUrl(enviroment.getProperty("url"));
////		dataSource.setUsername(enviroment.getProperty("userName"));
//		dataSource.setUsername("sa");
////		dataSource.setPassword(enviroment.getProperty("password"));
//		dataSource.setPassword("tat14082001");
//		System.out.println(dataSource.getUrl());
        
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
