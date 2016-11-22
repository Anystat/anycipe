package ru.anystat.anycipe.rest.repositories;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import ru.anystat.anycipe.rest.context.MongoDataBaseContext;

/**
 * Created by ustits on 13.11.16.
 */
public abstract class AbstractRepository implements Repository {

    private String collectionName;
    private String searchField;

    @Autowired
    private MongoDataBaseContext mongoDataBaseContext;

    public AbstractRepository(String collectionName, String searchField) {
        this.collectionName = collectionName;
        this.searchField = searchField;
    }

    @Override
    public final Iterable<Document> findAll() {
        return getDBContext().getCollection(collectionName).find();
    }

    @Override
    public Iterable<Document> findByName(String name) {
        return getDBContext().
                getCollection(collectionName)
                .find(Filters.eq(searchField, name));
    }

    @Override
    public Iterable<Document> findByPattern(String regex) {
        return getDBContext()
                .getCollection(collectionName)
                .find(Filters.regex(searchField, regex));
    }

    protected MongoDatabase getDBContext() {
        return mongoDataBaseContext.getContext();
    }
}
