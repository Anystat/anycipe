package ru.anystat.anycipe.rest;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import org.bson.Document;

/**
 * Created by ustits on 08.11.16.
 */
public class Main {

    public static void main(String[] args) {
        FindIterable<Document> iterable = MongoConnector.getDB().getCollection("restaurants").find();
        iterable.forEach(new Block<Document>() {
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
    }
}
