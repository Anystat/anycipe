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

    private static final String DB_NAME = "ingredients";
    private static final String INGREDIENT_NAME = "ingredient";

    public IngredientsRepository(@Value(DB_NAME) String dbName) {
        super(dbName);
    }

    public Iterable<Document> findByName(String name) {
        return getDBContext().
                getCollection(DB_NAME)
                .find(Filters.eq(INGREDIENT_NAME, name));
    }
}
