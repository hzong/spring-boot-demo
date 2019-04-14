package com.example.hz.demospringboot.datasource;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Classname DataSourcesysConfig
 * @Description TODO
 * @Date 2019-03-16 10:28
 * @Created by hzong
 */
@Configuration
@MapperScan(basePackages = "com.example.hz.demospringboot.mapper.sys", sqlSessionTemplateRef  = "sysSqlSessionTemplate")
public class DataSourceSysConfig {
    @Bean(name = "sysDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sys")
    public DataSource sysDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sysSqlSessionFactory")
    public SqlSessionFactory sysSqlSessionFactory(@Qualifier("sysDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/sys/mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "sysTransactionManager")
    public DataSourceTransactionManager sysTransactionManager(@Qualifier("sysDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sysSqlSessionTemplate")
    public SqlSessionTemplate sysSqlSessionTemplate(@Qualifier("sysSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
