package com.numberone;



import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * 启动程序
 * 
 * @author numberone
 */


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableCaching

public class NumberOneApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(NumberOneApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  NumberOne启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }


}