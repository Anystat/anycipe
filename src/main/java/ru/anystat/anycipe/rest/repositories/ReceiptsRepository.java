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

    private static final String DB_NAME = "receipts";
    private static final String RECEIPT_FIELD = "receipt";

    public ReceiptsRepository(@Value(DB_NAME) String dbName) {
        super(dbName);
    }

        public Iterable<Document> findByName(String name) {
        return getDBContext()
                .getCollection(DB_NAME)
                .find(Filters.eq(RECEIPT_FIELD, name));
    }
}
