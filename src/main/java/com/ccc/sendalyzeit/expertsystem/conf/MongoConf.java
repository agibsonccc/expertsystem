package com.ccc.sendalyzeit.expertsystem.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

@Configuration
public class MongoConf {
	public @Bean MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "mydatabase");
    }
	public @Bean
	Mongo mongo() throws Exception {
		return new Mongo("localhost");
	}
}
