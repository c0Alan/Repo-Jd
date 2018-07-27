package com.suntek.vehicle.file.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis Mapper 类扫描类
 * 
 * @author liuxilin
 * @date 2018/7/27 22:04
 */
@Configuration
@MapperScan("com.suntek.vehicle.file.mybatis.mapper")
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.suntek.vehicle.file.mybatis.mapper");
        return mapperScannerConfigurer;
    }
}