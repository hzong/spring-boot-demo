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
 * @Classname DataSourceHzimConfig
 * @Description TODO
 * @Date 2019-03-16 10:28
 * @Created by hzong
 */
@Configuration
@MapperScan(basePackages = "com.example.hz.demospringboot.mapper.hzim", sqlSessionTemplateRef  = "hzimSqlSessionTemplate")
public class DataSourceHzimConfig {
    @Bean(name = "hzimDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hzim")
    @Primary
    public DataSource hzimDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "hzimSqlSessionFactory")
    @Primary
    public SqlSessionFactory hzimSqlSessionFactory(@Qualifier("hzimDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/hzim/mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "hzimTransactionManager")
    @Primary
    public DataSourceTransactionManager hzimTransactionManager(@Qualifier("hzimDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "hzimSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate hzimSqlSessionTemplate(@Qualifier("hzimSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
