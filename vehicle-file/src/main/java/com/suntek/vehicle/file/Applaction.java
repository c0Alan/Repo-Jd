package com.suntek.vehicle.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 程序启动入口
 *
 * @author liuxilin
 * @date 2018/7/27 22:04
 */
@SpringBootApplication
@EnableScheduling
@EnableCaching
public class Applaction {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Applaction.class, args);
    }
}
