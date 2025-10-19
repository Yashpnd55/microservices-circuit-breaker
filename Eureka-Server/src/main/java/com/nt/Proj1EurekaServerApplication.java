package com.nt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Proj1EurekaServerApplication {
	
	private static Logger logger = LoggerFactory.getLogger(Proj1EurekaServerApplication.class);
			
	public static void main(String[] args) {
		logger.debug("start of main(-) method");
		SpringApplication.run(Proj1EurekaServerApplication.class, args);
		logger.debug("end of main(-) method");
	}

}
