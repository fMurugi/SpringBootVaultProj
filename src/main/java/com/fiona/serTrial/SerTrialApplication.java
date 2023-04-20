package com.fiona.serTrial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;


@SpringBootApplication
@EnableConfigurationProperties(AppConfiguration.class)

public class SerTrialApplication  {

//	private Logger logger = LoggerFactory.getLogger(SerTrialApplication.class);
//	public SerTrialApplication(AppConfiguration appConfiguration) {
//		this.appConfiguration = appConfiguration;
//	}
public static void main(String[] args) {
	SpringApplication.run(SerTrialApplication.class, args);
	 AppConfiguration appConfiguration = new AppConfiguration();
	try{
		appConfiguration.appCon();
		appConfiguration.dbConnection();
	} catch (IOException e) {
		throw new RuntimeException(e);
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}


//	@Override
//	public void run(String... args) throws Exception {
//		logger.info("_________---------------");
//		logger.info("Username: "+appConfiguration.getUsername());
//		logger.info("Password: "+appConfiguration.getPassword());
//
//	}


}
