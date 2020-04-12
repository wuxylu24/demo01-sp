package com.shp.demo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by wuxylu on 2020/4/12.
 */
@SpringBootApplication
@EnableEurekaServer
public class ShpDemoEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShpDemoEurekaApplication.class, args);
    }
}
