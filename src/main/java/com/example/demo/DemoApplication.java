package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@MapperScan(basePackages ="com.example.demo.dao.*")
@Slf4j
public class DemoApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application =SpringApplication.run(DemoApplication.class, args);
String ip = InetAddress.getLocalHost().getHostAddress();
        Environment env = application.getEnvironment();
String port = env.getProperty("server.port");
        System.out.println("swagger：\thttp://"+ip+":"+port + "/swagger-ui/index.html");
    }


}
