package ru.anystat.anycipe.rest;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

/**
 * Created by ustits on 08.11.16.
 */
public class MongoConnector {

    private static MongoConnector ourInstance = new MongoConnector();

    public static MongoConnector getInstance() {
        return ourInstance;
    }

    private static MongoClient mongoClient;

    private MongoConnector() {
        MongoClientURI uri = new MongoClientURI("mongodb://54.93.164.57");
        mongoClient = new MongoClient(uri);
    }

    public static MongoDatabase getDB() {
        return mongoClient.getDatabase("test");
    }
}
