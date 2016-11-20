package ru.anystat.anycipe.rest.repositories;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ustits on 10.11.16.
 */
@Component
public class ReceiptsRepository extends AbstractRepository {

    private static final String COLLECTION = "receipts";
    private static final String RECEIPT_FIELD = "receipt";

    public ReceiptsRepository(@Value(COLLECTION) String dbName) {
        super(dbName);
    }

    public Iterable<Document> findByName(String name) {
        return getDBContext()
                .getCollection(COLLECTION)
                .find(Filters.eq(RECEIPT_FIELD, name));
    }

    public Iterable<Document> findByMultipleParams(String[] params) {
        Document[] documents = new Document[params.length];
        for (int i = 0; i < params.length; i++) {
            documents[i] = new Document("", params[i]);
        }
        return getDBContext().getCollection(COLLECTION).find(Filters.and(documents));
    }

}
