package org.iona.kitesurf.app;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@ComponentScan(basePackages = "org.iona")
public class KitesurfApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(KitesurfApplication.class, args);
	}

	@Bean
	@Qualifier("viewResolver")
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/#/");
		internalResourceViewResolver.setSuffix("");
		return internalResourceViewResolver;
	}
}
