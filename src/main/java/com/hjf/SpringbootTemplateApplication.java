package com.hjf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 数据库连接池,mybatis,加分页插件为初始项目时加入,查考的下面链接
 * https://blog.csdn.net/qq_38977097/article/details/80778004
 */
@SpringBootApplication
@MapperScan("com.hjf.dao")
@EnableTransactionManagement
public class SpringbootTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTemplateApplication.class, args);
    }

}
