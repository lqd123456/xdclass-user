package com.xdclass.userapp;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.xdclass.userapp.controller")
@MapperScan("com.xdclass.userapp.mapper")
@EnableDubboConfig
@DubboComponentScan("com.xdclass.userapp.service.dubbo")
public class UserAppApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(UserAppApplication.class, args);

        // kill -15关闭JVM
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
        {
            @Override public void run()
            {
                System.out.println("执行JVM ShoutdownHook!");
            }
        }));
    }
}
