package ru.anystat.anycipe.rest;

import com.mongodb.client.MongoDatabase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.anystat.anycipe.rest.configs.MongoConfiguration;

/**
 * Created by ustits on 08.11.16.
 */
public class RestContext {

    private static RestContext ourInstance = new RestContext();

    public static RestContext getInstance() {
        return ourInstance;
    }

    private static ApplicationContext context;

    private RestContext() {
        context = new AnnotationConfigApplicationContext(MongoConfiguration.class);
    }

    public MongoDatabase getDB() {
        return context.getBean(MongoDatabase.class);
    }
}
