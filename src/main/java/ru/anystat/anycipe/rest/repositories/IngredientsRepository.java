package ru.anystat.anycipe.rest.repositories;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ustits on 12.11.16.
 */
@Component
public class IngredientsRepository extends AbstractRepository {

    private static final String COLLECTION = "ingredients";
    private static final String INGREDIENT_NAME = "ingredient";

    public IngredientsRepository(@Value(COLLECTION) String dbName) {
        super(dbName);
    }

    public Iterable<Document> findByName(String name) {
        return getDBContext().
                getCollection(COLLECTION)
                .find(Filters.eq(INGREDIENT_NAME, name));
    }
}
