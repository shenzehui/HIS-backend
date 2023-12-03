package com.neu.his;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author szh
 */
@SpringBootApplication
@EnableTransactionManagement    //启用事务
@EnableScheduling               //启用定时器
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
