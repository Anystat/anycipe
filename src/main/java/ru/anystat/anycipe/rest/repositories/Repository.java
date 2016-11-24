package ru.anystat.anycipe.rest.repositories;

import com.mongodb.client.FindIterable;
import org.bson.Document;

/**
 * Created by ustits on 10.11.16.
 */
public interface Repository {

    FindIterable<Document> findAll();

    FindIterable<Document> findByName(String name);

    FindIterable<Document> findByPattern(String regex);
}
