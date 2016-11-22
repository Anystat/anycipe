package ru.anystat.anycipe.rest.repositories;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ustits on 10.11.16.
 */
@Component
public class ReceiptsRepository extends AbstractRepository {

    private static final String COLLECTION = "receipts";
    private static final String RECEIPT_FIELD = "receipt";

    public ReceiptsRepository(@Value(COLLECTION) String dbName,
                              @Value(RECEIPT_FIELD) String searchField) {
        super(dbName, searchField);
    }

    public Iterable<Document> findByMultipleParams(String[] params) {
        Document[] documents = new Document[params.length];
        for (int i = 0; i < params.length; i++) {
            documents[i] = new Document("ingredients.name", params[i]);
        }
        return getDBContext().getCollection(COLLECTION).find(Filters.and(documents));
    }
}
