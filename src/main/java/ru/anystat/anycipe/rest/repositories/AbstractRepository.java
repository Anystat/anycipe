package ru.anystat.anycipe.rest.repositories;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import ru.anystat.anycipe.rest.context.MongoDataBaseContext;

/**
 * Created by ustits on 13.11.16.
 */
public abstract class AbstractRepository implements Repository {

    private String dbName;

    @Autowired
    private MongoDataBaseContext mongoDataBaseContext;

    public AbstractRepository(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public final Iterable<Document> findAll() {
        return getDBContext().getCollection(dbName).find();
    }

    protected MongoDatabase getDBContext() {
        return mongoDataBaseContext.getContext();
    }
}
