package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author suone
 */
@SpringBootApplication
@MapperScan("com.wallet.dao")
public class PaymentAppication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentAppication.class,args);
    }
}
