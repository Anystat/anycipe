package ru.anystat.anycipe.rest.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ustits on 12.11.16.
 */
@Component
public class IngredientsRepository extends AbstractRepository {

    private static final String COLLECTION = "ingredients";
    private static final String INGREDIENT_NAME = "ingredient";

    public IngredientsRepository(@Value(COLLECTION) String collectionName,
                                 @Value(INGREDIENT_NAME) String searchField) {
        super(collectionName, searchField);
    }
}
