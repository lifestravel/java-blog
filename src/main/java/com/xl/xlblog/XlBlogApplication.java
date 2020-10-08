package com.xl.xlblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author Mypc
 */
@SpringBootApplication
@EnableTransactionManagement
public class XlBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(XlBlogApplication.class, args);
    }



}
