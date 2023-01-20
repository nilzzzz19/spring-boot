package com.example.myboxchat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {

	@Value("${spring.data.mongodb.host}")
	private String mongoHost;

	@Value("${spring.data.mongodb.port}")
	private int mongoPort;

	@Value("${spring.data.mongodb.database}")
	private String mongoDbName;

	/*
	 * cannot instantiate MongoClient directly Instead used Mongoclients class to
	 * create a MongoClient for us w/o username and pwd.
	 */
	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create(
				new ConnectionString("mongodb://" + mongoHost + ":" + mongoPort));
	}
	
	//Alternate solution
	/*
	 * @Bean public MongoClient mongoClient() { MongoClientSettings settings =
	 * MongoClientSettings.builder() .applyConnectionString(new
	 * ConnectionString("mongodb://" + mongoHost + ":" + mongoPort)) .build();
	 * return MongoClients.create(settings); }
	 */

}
