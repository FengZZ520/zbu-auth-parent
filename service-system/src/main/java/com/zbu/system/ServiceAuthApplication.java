package com.zbu.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: ServiceAuthApplication
 * Package: com.zbu.system
 * Description:
 *
 * @Author: 冯振卓
 * @Create: 2023/1/6 - 11:09
 * @Version: v1.0
 */


@MapperScan("com.zbu.system.mapper")
@SpringBootApplication
public class ServiceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }

}