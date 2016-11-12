package ru.anystat.anycipe.rest.repositories;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.anystat.anycipe.rest.RestContext;

/**
 * Created by ustits on 12.11.16.
 */
@Component
public class IngredientsRepository implements Repository {

    private static final String DB_NAME = "ingredients";
    private static final String INGREDIENT_NAME = "ingredient";

    @Autowired
    private RestContext restContext;

    public Iterable<Document> findAll() {
        return restContext.getContext().getCollection(DB_NAME).find();
    }

    public Iterable<Document> findByName(String name) {
        return restContext.getContext()
                .getCollection(DB_NAME)
                .find(Filters.eq(INGREDIENT_NAME, name));
    }
}
