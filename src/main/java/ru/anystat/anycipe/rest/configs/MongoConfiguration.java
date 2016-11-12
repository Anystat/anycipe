package ru.anystat.anycipe.rest.configs;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ustits on 09.11.16.
 */
@Configuration
public class MongoConfiguration {

    @Bean
    public MongoDatabase mongoDatabase() {
        MongoClientURI uri = new MongoClientURI("mongodb://54.93.164.57");
//        MongoClient mongoClient = new MongoClient(uri);
        MongoClient mongoClient = new MongoClient();
        return mongoClient.getDatabase("anycipe");
    }
}
