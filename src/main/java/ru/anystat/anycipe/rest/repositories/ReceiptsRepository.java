package ru.anystat.anycipe.rest.repositories;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.anystat.anycipe.rest.RestContext;

/**
 * Created by ustits on 10.11.16.
 */
@Component
public class ReceiptsRepository implements Repository {

    private static final String DB_NAME = "restaurants";

    @Autowired
    private RestContext restContext;

    public Iterable<Document> findAll() {
        return restContext.getContext().getCollection(DB_NAME).find();
    }

    public Iterable<Document> findByName(String name) {
        return restContext.getContext()
                .getCollection(DB_NAME)
                .find(Filters.eq("borough", name));
    }
}
