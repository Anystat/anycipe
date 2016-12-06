package ru.anystat.anycipe.rest.repositories;

import com.mongodb.client.FindIterable;
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
    private static final String CATEGORY_FIELD_NAME = "category";

    public IngredientsRepository(@Value(COLLECTION) String collectionName,
                                 @Value(INGREDIENT_NAME) String searchField) {
        super(collectionName, searchField);
    }

    public FindIterable<Document> findByCategory(String category) {
        return getDBContext()
                .getCollection(COLLECTION)
                .find(Filters.eq(CATEGORY_FIELD_NAME, category));
    }
}
