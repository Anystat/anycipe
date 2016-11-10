package ru.anystat.anycipe.rest.repositories;

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

    public Iterable<Document> getAll() {
        return restContext.getContext().getCollection(DB_NAME).find();
    }
}
