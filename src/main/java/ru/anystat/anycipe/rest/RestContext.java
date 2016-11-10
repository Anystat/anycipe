package ru.anystat.anycipe.rest;

import com.mongodb.client.MongoDatabase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.anystat.anycipe.rest.configs.MongoConfiguration;

/**
 * Created by ustits on 08.11.16.
 */
@Component
public class RestContext implements DataBaseContext<MongoDatabase> {

    private static ApplicationContext context;

    private RestContext() {
        context = new AnnotationConfigApplicationContext(MongoConfiguration.class);
    }

    public MongoDatabase getContext() {
        return context.getBean(MongoDatabase.class);
    }

}
