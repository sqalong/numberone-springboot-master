package com.numberone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author numberone
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class NumberOneApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(NumberOneApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  NumberOne启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}