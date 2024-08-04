package com.biguncles.ordinary;

import com.biguncles.ordinary.event.ServerStartEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



/**
 * 程序入口类
 * @author yangchao
 *
 * */

@Configuration   //标注一个类是配置类，spring boot在扫到这个注解时自动加载这个类相关的功能，比如前面的文章中介绍的配置AOP和拦截器时加在类上的Configuration
@SpringBootApplication
@ComponentScan("com.biguncles.ordinary.**")
@EntityScan("com.biguncles.ordinary.**.po")
@EnableJpaRepositories("com.biguncles.ordinary.**.dao")
public class OrdinaryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(OrdinaryApplication.class, args);
		applicationContext.publishEvent(new ServerStartEvent(applicationContext));
	}

}

