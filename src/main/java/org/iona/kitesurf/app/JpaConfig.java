package org.iona.kitesurf.app;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages="org.iona")
@EnableTransactionManagement
@EntityScan(basePackages={"org.iona"})
public class JpaConfig {
	
	
	
	

}
